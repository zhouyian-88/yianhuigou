package com.yian.huigou.service;

import com.yian.huigou.pojo.Cart;
import com.yian.huigou.pojo.Good;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: yianzhou
 * @email: 2873642764@qq.com
 * @desc:
 * @datetime: 2022-12-08-19:13
 */

public interface GoodService {
    List<Good> findGoodByCategoryIdOrBrandId(int categoryId,int brandId);

    Good findGoodByGoodId(int goodId);


}
