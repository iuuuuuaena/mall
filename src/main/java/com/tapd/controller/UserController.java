package com.tapd.controller;

import com.tapd.POJO.User;
import com.tapd.enums.ResponseStatus;
import com.tapd.service.UserService;
import com.tapd.serviceimpl.UserServiceImpl;
import com.tapd.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author jxd
 * @Date 2020-05-31  20:03
 * @Version 1.0
 */

@Controller
public class UserController {

    Logger logger = LoggerFactory.getLogger(getClass());

    // -------------------------------后台------------------------------

    UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * 跳转到用户列表界面，并显示所有的用户
     *
     * @return
     */
    @GetMapping(value = "/users")
    // @RequestMapping(value = "/users",method = RequestMethod.GET)
    // 查询所有员工
    public String usersList(Model model) {
        List<User> allUser = userService.findAll();
        model.addAttribute("users", allUser);
        System.out.println("正在进入用户列表界面");
        // 默认拼串，拼到classpath：/templates/ xxx.html
        return "user/list";
    }

    // 跳转到用户添加页面
    @GetMapping(value = "/user")
    public String toAddPage() {
        // // 查出员工信息
        // Collection<Department> departments = departmentDao.getDepartments();
        // // 歇会去
        // model.addAttribute("depts",departments);
        return "user/add";
    }


    // 添加用户
    // springMVC会将我们的请求参数和对应的javabean参数一一对应起来，所以叫做自动封装！！！1
    @PostMapping(value = "/user")
    public String addUsers(User user, Model model) {

        System.out.println("要保存的用户数据是" + user);
        if (user.getUser_account() == null || user.getUser_account() == "" || user.getUser_password() == null || user.getUser_password() == "") {
            model.addAttribute("msg", "用户名和密码不能为空");
            return "user/add";
        } else {
            //保存 用户数据
            if (userService.create(user) == 1) {
                System.out.println("保存用户:" + user);
                // c重定向
                // forward：转发到一个地址   /代表
                return "redirect:/users";
            } else {
                model.addAttribute("msg", "用户插入失败，用户名重复");
                return "user/add";
            }
        }
    }


    // 携带id去修改员工信息的页面
    @GetMapping(value = "/user/{account}")
    public String toEditPage(@PathVariable("account") String account, Model model) {

        // 查到id的员工
        User user = userService.findByAccount(account);
        // 回写回去
        System.out.println("员工account为" + account);
        model.addAttribute("user", user);

        // Collection<Department> departments = departmentDao.getDepartments();
        //
        // model.addAttribute("depts",departments);

        // add是修改添加二合一的页面
        return "user/add";

    }


    // 修改用户信息
    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public String updataUser(User user) {
        // 这里把传来的包括id和其他信息自动封装到employee里面，我们来查看是否修改完成
        System.out.println("正在修改用户");
        System.out.println("要修改的用户为：" + user);
        // 保存
        int index = userService.update(user);
        return "redirect:/users";
    }


    @DeleteMapping(value = "/user/{account}")
    public String deleteUser(@PathVariable("account") String account) {
        System.out.println("要删除的员工account为:" + account);
        userService.delete(account);
        return "redirect:/users";
    }


//    ---------------------------------前台-----------------------------------------



    // 通过account返回用户信息
    @ResponseBody
    @GetMapping(value = "/getUserInfo/{account}")
    public Object getByAccount(@PathVariable String account) {

        //使用account返回这个用户的信息

        if (account == null || account == ""){
            //返回没有这个用户
            logger.error("用户名不能为空");
            return ResultUtils.fail(ResponseStatus.NO_USER_OR_ACCOUNT_ERROR.getCode(),ResponseStatus.NO_USER_OR_ACCOUNT_ERROR.getMsg(),ResponseStatus.NO_USER_OR_ACCOUNT_ERROR);
        }else{
            User user = userService.findByAccount(account);
            if(user != null){
                logger.info("存在该用户");
                return user;
            }else{
                logger.error("不存在该用户");
                return ResultUtils.fail(ResponseStatus.NO_USER_OR_ACCOUNT_ERROR.getCode(),ResponseStatus.NO_USER_OR_ACCOUNT_ERROR.getMsg(),ResponseStatus.NO_USER_OR_ACCOUNT_ERROR);
            }
        }
    }



    @ResponseBody
    @GetMapping("/changeImage")
    public Object updataImage(@RequestParam("user_account")String user_account,
                              @RequestParam("new_image")String new_image){
        if (user_account == null || user_account.equals("undefined")){
            //1000
            return ResultUtils.fail(ResponseStatus.NO_USER_OR_ACCOUNT_ERROR.getCode(),ResponseStatus.NO_USER_OR_ACCOUNT_ERROR.getMsg(),ResponseStatus.NO_USER_OR_ACCOUNT_ERROR);
        }

        int result = userService.updateImage(user_account, new_image);
        if(result != 1){
            logger.error("用户更新头像失败");
            // 1013
            return ResultUtils.fail(ResponseStatus.ICON_CHANGE_FAIL.getCode(),ResponseStatus.ICON_CHANGE_FAIL.getMsg(),ResponseStatus.ICON_CHANGE_FAIL);
        }else{
            logger.info("用户更新头像成功");
            // 1014
            return ResultUtils.fail(ResponseStatus.ICON_CHANGE_SUCCESS.getCode(),ResponseStatus.ICON_CHANGE_SUCCESS.getMsg(),ResponseStatus.ICON_CHANGE_SUCCESS);
        }

    }



    // 更新用户信息
    @ResponseBody
    @GetMapping(value = "/updateInfo")
    public Object updataUser2(User user) {
        // 这里把传来的包括id和其他信息自动封装到employee里面，我们来查看是否修改完成
        System.out.println("正在修改用户");
        System.out.println("要修改的用户为：" + user);
        // 保存
        int index = userService.update2(user);
        if (index != 1){
            //1015
            return ResultUtils.fail(ResponseStatus.USER_INFO_CHANGE_FAIL.getCode(),ResponseStatus.USER_INFO_CHANGE_FAIL.getMsg(),ResponseStatus.USER_INFO_CHANGE_FAIL);
        }else{
            //1016
            return ResultUtils.fail(ResponseStatus.USER_INFO_CHANGE_SUCCESS.getCode(),ResponseStatus.USER_INFO_CHANGE_SUCCESS.getMsg(),ResponseStatus.USER_INFO_CHANGE_SUCCESS);
        }

    }
}
