package com.tapd.controller;

import com.tapd.entities.User;
import com.tapd.serviceimpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author jxd
 * @Date 2020-06-01  09:12
 * @Version 1.0
 */

@Controller
public class RegisterController {



    @Autowired
    UserServiceImpl userServiceImpl;

    /**
     * 处理注册请求
     * @param username  账号
     * @param password  密码
     * @param email     email
     * @param map       返回的信息
     * @return
     */
    @GetMapping(value= "/mail/register")
    public String register(@RequestParam("username")String username,
                           @RequestParam("password") String password,
                           @RequestParam("email")String email,  Map<String,String> map ){

        System.out.println("username:"+username);
        System.out.println("password" + password);
        System.out.println("Eamil:" + email);
        // 写回浏览器的map
        // Map<String,String> map = new HashMap<>();
        // 返回的插入的数值
        User newUser  = new User(null, null, username, password, null, null, null, null, null, null, null, email);
        int userNum= userServiceImpl.create(newUser);
        System.out.println("新用户为"+newUser);
        if (userNum == 1){
            // 写回成功信息
            map.put("msg","Register successful!!");
            // model.addAllAttributes(map);
            // 重定向到登录页面
            return "login";
        }else{
            // 写回失败信息
            map.put("msg","Register failed! Please try again");
            // model.addAllAttributes(map);
            // 重定向到注册页面
            return "register";
        }


    }
}
