package com.yian.huigou.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * tb_user
 * @author 
 */
@Data
public class User implements Serializable {
    private Integer userId;

    private String userName;

    private String userPassword;

    private String userSalt;

    private static final long serialVersionUID = 1L;

}