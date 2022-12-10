package com.yian.huigou.mapper;

import com.yian.huigou.pojo.Cart;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: yianzhou
 * @email: 2873642764@qq.com
 * @desc:
 * @datetime: 2022-12-09-20:12
 */
@Mapper
public interface CartMapper {
    List<Cart> selectCartByUserId(int userId);

    int addTocard(Cart cart);

    int deleteByCardId(int cartId);
}
