package com.yian.huigou.controller;

import com.yian.huigou.pojo.User;
import com.yian.huigou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: yianzhou
 * @email: 2873642764@qq.com
 * @desc:
 * @datetime: 2022-12-09-19:20
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    @ResponseBody
    public Map<String,String> login(String userName, String userPassword, String remeberMe, String settle, HttpSession session){
        Map<String,String> map = new HashMap<>();
        User user = userService.findUserNameAndUserPasswordByUserIdUser(userName, userPassword);
        if(user!=null){
            session.setAttribute("userName", user.getUserName());
            session.setAttribute("user", user);
            map.put("message", "success");
        }else{
            map.put("message", "failed");
        }

        return map;
    }

    @RequestMapping("/exit")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/good/home";
    }
}
