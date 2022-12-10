package com.yian.huigou.mapper;

import com.yian.huigou.pojo.SystemParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: yianzhou
 * @email: 2873642764@qq.com
 * @desc:
 * @datetime: 2022-12-08-20:05
 */
@Mapper
public interface SystemParamMapper {
   String selectSystemParamValueByName(String paramName);
}
