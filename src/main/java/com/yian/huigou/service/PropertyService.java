package com.yian.huigou.service;

import com.yian.huigou.pojo.ParProperty;
import com.yian.huigou.pojo.SubProperty;

import java.util.List;
import java.util.Map;

/**
 * @author: yianzhou
 * @email: 2873642764@qq.com
 * @desc:
 * @datetime: 2022-12-09-11:03
 */
public interface PropertyService {
    List<Map<ParProperty,List<SubProperty>>> getMapListByGoodId(int goodId);

   int getPriceByGoodId(int goodId, int[] subTypeIds);
}
