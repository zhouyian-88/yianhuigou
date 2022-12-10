package com.yian.huigou.mapper;

import com.yian.huigou.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectUserNameAndUserPasswordByUserIdUser(@Param("username") String username,@Param("password") String password);
}