package com.yian.huigou.test;

import com.yian.huigou.service.CartService;
import com.yian.huigou.service.PropertyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author: yianzhou
 * @email: 2873642764@qq.com
 * @desc:
 * @datetime: 2022-12-09-11:10
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class DomeTest {
    @Autowired
    private PropertyService propertyService;
    @Autowired
    private CartService cartService;
    @Test
    public void test(){
        propertyService.getMapListByGoodId(1);
    }

    @Test
    public void test1(){
         cartService.selectCartByUserId(33);
    }

}
