package com.tapd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author jxd
 * @Date 2020-05-12  22:50
 * @Version 1.0
 */
@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    public String returnHello(){
        return "hello";
    }

//    @RequestMapping({"/","/login.html"})
//    public String index(){
//        return "index";
//    }


}
