package com.tapd.controller;

import com.tapd.entities.Employee;
import com.tapd.entities.User;
import com.tapd.entities.UserLoginStatus;
import com.tapd.enums.ResponseStatus;
import com.tapd.service.UserService;
import com.tapd.serviceimpl.EmployeeServiceImpl;
import com.tapd.serviceimpl.UserServiceImpl;
import com.tapd.utils.CookieUtil;
import com.tapd.utils.JwtTokenUtils;
import com.tapd.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Author jxd
 * @Date 2020-05-13  16:42
 * @Version 1.0
 */
@Controller
public class LoginController {


    Logger logger = LoggerFactory.getLogger(this.getClass());


    //-----------------------------------后台管理-----------------------------------
    @Autowired
    EmployeeServiceImpl employeeServiceImpl;

    @PostMapping(value = "/mail/login")
    // @RequestMapping(value = "/users/login",method = RequestMethod.POST)
    public String loginManagementBackground(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map, HttpSession session) {
        System.out.println("用户：" + username + "准备登陆");
        // 如果登录成功，就跳转到页面
        Employee user = null;
        try {
            System.out.println("为" + employeeServiceImpl.findByAccount(username));
            Employee tempEmp = employeeServiceImpl.findByAccount(username);
            if (tempEmp == null) {
                map.put("msg", "不存在该账号,请重新输入,或者注册");
                return "login";
            } else {
                user = tempEmp;
            }
        } catch (Exception e) {
            e.getMessage();
        }
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





    //---------------------------------前台商城---------------------------------



    // 注入用户服务
    @Autowired
    UserService userService;


    // 使用Jwt的token
    JwtTokenUtils jwtTokenUtils;

    /**
     * 处理登录
     *
     * @param username
     * @param password
     * @param isKeeping
     * @param map
     * @param response
     * @return
     */
    @RequestMapping(value = "/user/login")
    public Object mailLogin(@RequestParam("username") String username,
                            @RequestParam("password") String password,
                            @RequestParam("isloginkeeping") Boolean isKeeping,
                            Map<String, String> map,
                            HttpServletResponse response, HttpServletRequest request) {

        System.out.println("用户：" + username + "要登录");
        System.out.println("密码是：" + password);
        System.out.println("保留状态是：" + isKeeping);

        User user = null;
        try {
            // 通过account寻找用户
            user = userService.findByAccount(username);
        } catch (Exception e) {
            // 如果报错，说明没找到用户
            logger.error("用户登录失败,错误信息:" + e);
            return ResultUtils.fail(ResponseStatus.NO_USER_OR_ACCOUNT_ERROR);
        }

        // 如果用户选择了保存登录状态的话！！！1
        if (isKeeping.equals(true)) {
            // 给这个用户保存状态
            UserLoginStatus loginStatus = userService.loginStatusKeep(user,password);
            // 如果登录状态为空，就说明用户账号密码错误
            if (loginStatus == null) {
                return ResultUtils.fail(com.tapd.enums.ResponseStatus.USERNAME_PASS_ERROR);
            }
            String token = jwtTokenUtils.generateToken(loginStatus);
            // 把token写回cookie
            CookieUtil.setCookie(response, "Authorization", token);
            map.put("token", token);
            // 返回 token
            return ResultUtils.ok(map);
        } else {
            // 如果不保存登录的话，就不用jwt
            return ResultUtils.ok(ResponseStatus.OK);

        }
    }
}
