package com.yian.huigou.service.impl;

import com.yian.huigou.mapper.SubPropertyMapper;
import com.yian.huigou.pojo.Good;
import com.yian.huigou.pojo.ParProperty;
import com.yian.huigou.pojo.SubProperty;
import com.yian.huigou.service.GoodService;
import com.yian.huigou.service.PropertyService;
import com.yian.huigou.utils.ParseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: yianzhou
 * @email: 2873642764@qq.com
 * @desc:
 * @datetime: 2022-12-09-11:04
 */
@Service
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    private SubPropertyMapper subPropertyMapper;

    @Autowired
    private GoodService goodService;

    @Override
    public List<Map<ParProperty, List<SubProperty>>> getMapListByGoodId(int goodId) {
        //定义一个基本map
        List<Map<ParProperty, List<SubProperty>>> mapList = new ArrayList<>();
        List<SubProperty> subPropertyList = subPropertyMapper.selectSubPropertyByGoodId(goodId);
        //定义一个parProperty
        List<ParProperty> parPropertyList = new ArrayList<>();
        //遍历subProperty，将里面的值放入到parPropertyList中
        for (SubProperty subProperty : subPropertyList) {
            parPropertyList.add(subProperty.getProperty());
        }
        //过滤掉parPropertyList里面重复的数据
        parPropertyList =  parPropertyList.stream().distinct().collect(Collectors.toList());
//        System.out.println(parPropertyList);
        Map<ParProperty, List<SubProperty>> baseMap = new HashMap<>();
        for (ParProperty parProperty : parPropertyList) {
            //每一个parProperty都对应者map的中一个key，其中的每个key都对应其中一个subProperty的集合
            //每次循环一个key，就会得到一个subProperty的结合
            List<SubProperty> valueList = new ArrayList<>();
            for (SubProperty subProperty : subPropertyList) {
                //说明subPropertyList是属于parProperty中的
                if(parProperty.getParPropertyId()==subProperty.getProperty().getParPropertyId()){
                    valueList.add(subProperty);
                    baseMap.put(parProperty,valueList);
                }
            }
        }
        //根据parPropertyId,将map分成三个部分
        Map<ParProperty, List<SubProperty>> map1 = new HashMap<>();

        Map<ParProperty, List<SubProperty>> map2 = new HashMap<>();
        Map<ParProperty, List<SubProperty>> map3 = new HashMap<>();
        for (ParProperty parProperty : baseMap.keySet()) {
            if(parProperty.getParPropertyId()<7||parProperty.getParPropertyId()==13){
                map1.put(parProperty,baseMap.get(parProperty));
            }else if(parProperty.getParPropertyId()==7){
                map2.put(parProperty,baseMap.get(parProperty));
            }else if(parProperty.getParPropertyId()>7&&parProperty.getParPropertyId()!=13){
                map3.put(parProperty,baseMap.get(parProperty));
            }
        }
        //将这三个map存储到mapList当中
        mapList.add(map1);
        mapList.add(map2);
        mapList.add(map3);
        System.out.println(mapList);
        return mapList;
    }

    @Override
    public int getPriceByGoodId(int goodId, int[] subTypeIds) {
        Good good = goodService.findGoodByGoodId(goodId);
        int discountPrice = subPropertyMapper.selectGoodDiscountPrice(subTypeIds);
        int price = good.getGoodCost()-discountPrice;
        if(price<good.getGoodMinPrice()){
            price = good.getGoodMinPrice();
        }
        return  price;
    }
}
