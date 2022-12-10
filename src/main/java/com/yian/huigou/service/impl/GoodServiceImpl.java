package com.yian.huigou.service.impl;

import com.yian.huigou.mapper.GoodMapper;
import com.yian.huigou.pojo.Cart;
import com.yian.huigou.pojo.Good;
import com.yian.huigou.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

/**
 * @author: yianzhou
 * @email: 2873642764@qq.com
 * @desc:
 * @datetime: 2022-12-08-19:14
 */
@Service
public class GoodServiceImpl implements GoodService {
    @Autowired
    private GoodMapper goodMapper;
    @Override
    public List<Good> findGoodByCategoryIdOrBrandId(int categoryId, int brandId) {
        return goodMapper.selectGoodByCategoryIdOrBrandId(categoryId,brandId);
    }

    @Override
    public Good findGoodByGoodId(int goodId) {
        return goodMapper.getGoodByGoodId(goodId);
    }

}
