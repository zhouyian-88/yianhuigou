package com.yian.huigou.service.impl;

import com.yian.huigou.mapper.CartMapper;
import com.yian.huigou.pojo.Cart;
import com.yian.huigou.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: yianzhou
 * @email: 2873642764@qq.com
 * @desc:
 * @datetime: 2022-12-09-20:33
 */
@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartMapper cartMapper;
    @Override
    public List<Cart> selectCartByUserId(int userId) {
        return cartMapper.selectCartByUserId(userId);
    }

    @Override
    public int addTocart(Cart cart) {
        return cartMapper.addTocard(cart);
    }

    @Override
    public int modifyByCardId(int cartId) {
        return cartMapper.deleteByCardId(cartId);
    }
}
