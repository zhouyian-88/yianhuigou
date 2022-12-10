package com.yian.huigou.service;

import com.yian.huigou.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author: yianzhou
 * @email: 2873642764@qq.com
 * @desc:
 * @datetime: 2022-12-09-19:29
 */
public interface UserService {
    User findUserNameAndUserPasswordByUserIdUser(String username, String password);

}
