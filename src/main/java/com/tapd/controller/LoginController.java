package com.tapd.controller;

import com.tapd.entities.Employee;
import com.tapd.serviceimpl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.util.Map;

/**
 * @Author jxd
 * @Date 2020-05-13  16:42
 * @Version 1.0
 */
@Controller
public class LoginController {


    @Autowired
    EmployeeServiceImpl employeeServiceImpl;

    @PostMapping(value = "/mail/login")
    // @RequestMapping(value = "/users/login",method = RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map, HttpSession session) {
        System.out.println("用户：" + username + "准备登陆");
        // 如果登录成功，就跳转到页面
        Employee user = employeeServiceImpl.findByAccount(username);
        System.out.println(user);
        if (password.equals(user.getManager_password())) {
            System.out.println("用户" + username + "登陆成功！");
            System.out.println("正在设置session");
            session.setAttribute("loginUser", username);
            System.out.println("准备进入主界面");
            // 防止表单重复提交，重定向到dash页面
            return "redirect:/main.html";
        } else {
            map.put("msg", "登录名或者密码错误,请重新输入");
            // 登录不成功，还回到login页面
            return "login";
        }
    }


    /**
     * 注销用户
     * @param session
     * @return
     */
    @RequestMapping("/mail/logout")
    public String logOut(HttpSession session){
        // 让session立即失效
        session.invalidate();
        return "redirect:login";
    }
}
