package com.yian.huigou.pojo;

import lombok.Data;

/**
 * @author: yianzhou
 * @email: 2873642764@qq.com
 * @desc:
 * @datetime: 2022-12-09-16:46
 */
@Data
public class Cart {
    private Integer cartId;
    private Integer cartPrice;
    private Integer goodId;
    private Integer userId;
    private Good good;
}
