package com.yian.huigou.controller;

import com.yian.huigou.commons.SystemParamTool;
import com.yian.huigou.mapper.BrandMapper;
import com.yian.huigou.mapper.SystemParamMapper;
import com.yian.huigou.pojo.*;
import com.yian.huigou.service.*;
import com.yian.huigou.utils.ParseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: yianzhou
 * @email: 2873642764@qq.com
 * @desc:
 * @datetime: 2022-12-08-14:37
 */
@Controller
@RequestMapping("/good")
public class GoodController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private BrandService brandService;
    @Autowired
    private GoodService goodService;
    @Autowired
    private PropertyService propertyService;
    @Autowired
    private CartService cartService;
    @RequestMapping(value = {"/home","/query","/querybrand"})
    public String home(@RequestParam(defaultValue = "1") int categoryId,@RequestParam(defaultValue = "-1")int brandId, Model model){
        List<Category> categoryList = categoryService.findAllCategory();
        List<Brand> brandList = brandService.findByBrandListByCategoryId(categoryId);
        List<Good> goodList ;
        if(brandId==-1){
          goodList =  goodService.findGoodByCategoryIdOrBrandId(categoryId, brandId);
        }else{
            //二级分类
          goodList =  goodService.findGoodByCategoryIdOrBrandId(-1, brandId);
        }
        model.addAttribute("goodList", goodList);
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("brandList", brandList);
        return "home";
    }

    @RequestMapping("/info")
    public String queryBrand(int goodId,Model model){
        Good good = goodService.findGoodByGoodId(goodId);
        List<Map<ParProperty, List<SubProperty>>> mapList = propertyService.getMapListByGoodId(goodId);
        model.addAttribute("mapList",mapList);
        model.addAttribute("good",good);
        return "info";
    }

    @RequestMapping("/calc")
    public String calcInfo(int goodId,int[] subTypeIds,Model model,HttpSession session){
        List<Cart> cartList = new ArrayList<>();
        //需要加载购物车中的信息
        User user = (User) session.getAttribute("user");
        if(user!=null){
            //从数据库中取出数据
            cartList = cartService.selectCartByUserId(user.getUserId());
        }else{
            List<Cart> cartListTemp = SystemParamTool.CART_LIST;
            cartList=cartListTemp;
        }
        Good good = goodService.findGoodByGoodId(goodId);
        int goodPrice = propertyService.getPriceByGoodId(goodId,subTypeIds);
        model.addAttribute("integers", ParseUtils.parseIntToList(goodPrice));
        model.addAttribute("good",good);
        model.addAttribute("goodPrice",goodPrice);
        model.addAttribute("subTypeIds",subTypeIds);
        model.addAttribute("cartList",cartList);
        return "show_price";
    }


    @RequestMapping("/addcart")
    @ResponseBody
    public Map<String,String> addCart(Integer goodId, Integer goodPrice, HttpSession session){
        Map<String,String> map = new HashMap<>();
        Cart cart = new Cart();
        cart.setCartPrice(goodPrice);
        cart.setGood(goodService.findGoodByGoodId(goodId));
        //查看当前用户是否已登入
        User user = (User) session.getAttribute("user");
        if(user!=null){
            //添加用户的id
            cart.setUserId(user.getUserId());
            System.out.println(cart);
            int result = cartService.addTocart(cart);
            if(result == 1){
                map.put("message", "success");
            }
        }else{
            //设计一个购物车id
            cart.setCartId(++SystemParamTool.CART_ID);
            //向临时购物车取数据
            SystemParamTool.CART_LIST.add(cart);
            map.put("message", "success");
        }
        return map;
    }

    @RequestMapping("/deletecart")
    @ResponseBody
    public Map<String,String> deleteCart(Integer cartId,HttpSession session){
        Map<String,String> map = new HashMap<>();
        //查看当前用户是否已登入
        User user = (User) session.getAttribute("user");
        if(user!=null){
            //通过cardId删除用户
            cartService.modifyByCardId(cartId);
            map.put("message", "success");
        }else{
            //通过cardId删除临时购物车中的数据
         List<Cart> cartList = new ArrayList<>();
            for (Cart cart : SystemParamTool.CART_LIST) {
                if(!(cart.getCartId()==cartId)){
                    cartList.add(cart);
                }
            }
            SystemParamTool.CART_LIST = cartList;

            map.put("message", "success");
        }
        return map;
    }

}
