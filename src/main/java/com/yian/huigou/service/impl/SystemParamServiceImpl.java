package com.yian.huigou.service.impl;

import com.yian.huigou.mapper.SystemParamMapper;
import com.yian.huigou.service.SystemParamService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: yianzhou
 * @email: 2873642764@qq.com
 * @desc:
 * @datetime: 2022-12-08-20:16
 */
@Service
public class SystemParamServiceImpl implements SystemParamService {
    @Autowired
    private SystemParamMapper systemParamMapper;
    @Override
    public String findSystemParamValueByParamName(String paramName) {
        return systemParamMapper.selectSystemParamValueByName(paramName);
    }
}
