package com.yian.huigou.service;

import com.yian.huigou.pojo.Cart;

import java.util.List;

/**
 * @author: yianzhou
 * @email: 2873642764@qq.com
 * @desc:
 * @datetime: 2022-12-09-20:32
 */
public interface CartService {
    List<Cart> selectCartByUserId(int userId);

    int addTocart(Cart cart);

    int modifyByCardId(int cartId);
}
