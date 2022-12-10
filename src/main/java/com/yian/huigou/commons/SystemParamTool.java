package com.yian.huigou.commons;

import com.yian.huigou.pojo.Cart;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yianzhou
 * @email: 2873642764@qq.com
 * @desc:
 * @datetime: 2022-12-08-20:33
 */
public class SystemParamTool {
    public static final String STATIC_SOURCE  = "static_source_path";
    public static final String MAIN_IMG  = "main_img";
    public static final String MAIN_LOGO  = "main_logo";
    public static final String SMALL_LOGO  = "small_logo";

    public static  List<Cart> CART_LIST = new ArrayList<>();//临时购物车存储数据的地方
    public static int CART_ID = 0;
}
