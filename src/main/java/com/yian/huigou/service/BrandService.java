package com.yian.huigou.service;

import com.yian.huigou.pojo.Brand;

import java.util.List;

/**
 * @author: yianzhou
 * @email: 2873642764@qq.com
 * @desc:
 * @datetime: 2022-12-08-16:50
 */
public interface BrandService {

    List<Brand> findByBrandListByCategoryId(int categoryId);
}
