package com.yian.huigou.mapper;

import com.yian.huigou.pojo.SubProperty;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: yianzhou
 * @email: 2873642764@qq.com
 * @desc:
 * @datetime: 2022-12-09-10:16
 */
@Mapper
public interface SubPropertyMapper {
    List<SubProperty> selectSubPropertyByGoodId(int goodId);

    int selectGoodDiscountPrice(int[] subTypeIds);
}
