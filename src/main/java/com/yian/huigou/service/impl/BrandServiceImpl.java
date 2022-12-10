package com.yian.huigou.service.impl;

import com.yian.huigou.mapper.BrandMapper;
import com.yian.huigou.pojo.Brand;
import com.yian.huigou.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.smartcardio.Card;
import java.util.List;

/**
 * @author: yianzhou
 * @email: 2873642764@qq.com
 * @desc:
 * @datetime: 2022-12-08-16:51
 */
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandMapper brandMapper;
    @Override
    public List<Brand> findByBrandListByCategoryId(int categoryId) {
        return brandMapper.selectBrandListByCategoryId(categoryId);
    }
}
