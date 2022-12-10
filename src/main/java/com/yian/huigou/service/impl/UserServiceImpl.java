package com.yian.huigou.service.impl;

import com.yian.huigou.mapper.UserMapper;
import com.yian.huigou.pojo.User;
import com.yian.huigou.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: yianzhou
 * @email: 2873642764@qq.com
 * @desc:
 * @datetime: 2022-12-09-19:29
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User findUserNameAndUserPasswordByUserIdUser(String username, String password) {
        return userMapper.selectUserNameAndUserPasswordByUserIdUser(username,password);
    }
}
