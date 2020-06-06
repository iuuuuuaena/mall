package com.tapd.controller;

import com.tapd.entities.Employee;
import com.tapd.entities.User;
import com.tapd.enums.ResponseStatus;
import com.tapd.service.EmailService;
import com.tapd.service.EmployeeService;
import com.tapd.service.UserService;
import com.tapd.serviceimpl.UserServiceImpl;
import com.tapd.utils.CodeUtil;
import com.tapd.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Author jxd
 * @Date 2020-06-01  09:12
 * @Version 1.0
 */

@Controller
public class RegisterController {

    //-----------------------------------后台管理-----------------------------------


    @Autowired
    EmployeeService employeeService;


    Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 管理后台处理注册请求
     *
     * @param username 账号
     * @param password 密码
     * @param email    email
     * @param map      返回的信息
     * @return
     */
    @GetMapping(value = "/mall/register")
    public String registerManagementBackground(@RequestParam("username") String username,
                                               @RequestParam("password") String password,
                                               @RequestParam("email") String email, Map<String, String> map) {

        System.out.println("username:" + username);
        System.out.println("password:" + password);
        System.out.println("Eamil:" + email);
        // 写回浏览器的map
        // Map<String,String> map = new HashMap<>();
        // 返回的插入的数值
        Employee employee = new Employee(null, null, username, password, null, email, null);
        int userNum = employeeService.create(employee);
        System.out.println("新用户为" + employee);
        if (userNum == 1) {
            // 写回成功信息
            map.put("msg", "Register successful!!");
            // model.addAllAttributes(map);
            // 重定向到登录页面
            return "login";
        } else {
            // 写回失败信息
            map.put("msg", "Register failed! Please try again");
            // model.addAllAttributes(map);
            // 重定向到注册页面
            return "register";
        }


    }
    //-----------------------------------前端商城-----------------------------------


    // 注入邮件服务
    @Autowired
    EmailService emailService;

    // 注入用户服务
    @Autowired
    UserService userService;


    /**
     * 前端商城处理注册操作
     *
     * @param
     * @param session
     * @return 返回相应的结果
     */
    @ResponseBody
    @GetMapping("/u/register")
    public Object registerMall(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               @RequestParam("email") String email, HttpSession session) {
        User user = new User(null, null, username, password, null, null, null, null, null, null, null, email);
        // 获取session中的验证码
        String code = (String) session.getAttribute("code");
        // 如果验证码为空 或者 验证码不是ok
        if (code == null || !code.equals("ok")) {
            System.out.println("code为" + code);
            return ResultUtils.fail(ResponseStatus.NO_CODE);
        }
        // 注册失败
        if (userService.create(user) != 1) {
            return ResultUtils.error(ResponseStatus.REGISTER_ERROR);
        }
        // 注册成功
        return ResultUtils.ok(ResponseStatus.REGISTER_SUCCESS);
    }


    /**
     * 获取验证码
     * @param
     * @param session
     * @return
     */
    @ResponseBody
    @GetMapping("/email/getCode")
    public Object getCode(@RequestParam("email") String email, HttpSession session) {
        // 从请求的map中获取email
        // String email = map.get("email");
        // 如果验证码为空，返回参数错误
        System.out.println("email是" + email);
        if (email == null) {
            return ResultUtils.fail(ResponseStatus.PARAM_ERROR);
        }
        // 如果邮箱存在，返回邮箱已注册
        if (userService.isUserExist(email)) {
            return ResultUtils.fail(ResponseStatus.USER_EMAIL_EXIST);
        }
        // 随机新建一个验证码
        String code = CodeUtil.randomCode();
        // 用 管理员的邮箱 向 用户的邮箱 发送邮件
        emailService.sendSimpleMail(email, "mall-email-code:", code);
        // 在把code放入session中
        session.setAttribute("code", code);
        logger.info("code:为" + code);
        //  返回验证码创建成功
        return ResultUtils.ok(ResponseStatus.CODE_GET_SUCCESS);
    }


    /**
     * 检查验证码的操作
     *
     * @param
     * @param session
     * @return
     */
    @ResponseBody
    @GetMapping("/email/checkCode")
    public Object checkCode(@RequestParam("email") String email,
                            @RequestParam("code") String code, HttpSession session) {
        // 从map中获取验证码
        // String code = map.get("code");
        System.out.println("正在进行验证码验证阶段");
        // 如果验证码为空，返回参数错误
        System.out.println("手机上获取的验证码为"+code);
        if (code == null) {
            logger.error("验证码传入错误");
            System.out.println("验证码错误");
            return ResultUtils.fail(ResponseStatus.PARAM_ERROR);
        }
        // 从session中获取验证码，
        String rel_code = (String) session.getAttribute("code");
        System.out.println("从session中获取的code为：");
        // 如果没有code，就是还没发送验证码
        if (rel_code == null) {
            logger.error("还没发送验证码，就检查验证码？");
            return ResultUtils.fail(ResponseStatus.NO_CODE);
        }
        // 如果验证码不正确，返回验证码不匹配
        if (!code.equals(rel_code)) {
            System.out.println("验证码不匹配");
            logger.error("验证码不匹配");
            return ResultUtils.fail(ResponseStatus.VEL_CODE_ERROR);
        }
        // 在session中把验证码设置为   OK ,表示，验证码验证成功，接下来应该去登录了！！！！
        session.setAttribute("code", "ok");
        return ResultUtils.ok(ResponseStatus.CODE_CHECK_SUCCESS);
    }


}
