package com.yian.huigou.service.impl;

import com.yian.huigou.mapper.CategoryMapper;
import com.yian.huigou.pojo.Category;
import com.yian.huigou.pojo.CategoryExample;
import com.yian.huigou.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: yianzhou
 * @email: 2873642764@qq.com
 * @desc:
 * @datetime: 2022-12-08-16:19
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public List<Category> findAllCategory() {
        return categoryMapper.selectByExample(new CategoryExample());
    }
}
