package com.tapd.controller;

import com.tapd.entities.Department;
import com.tapd.entities.Employee;
import com.tapd.entities.User;
import com.tapd.serviceimpl.UserServiceImpl;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

/**
 * @Author jxd
 * @Date 2020-05-31  20:03
 * @Version 1.0
 */

@Controller
public class UserController {


    // -------------------------------后台------------------------------
    @Autowired
    UserServiceImpl userServiceImpl;


    /**
     * 跳转到用户列表界面，并显示所有的用户
     * @return
     */
    @GetMapping(value = "/users")
    // @RequestMapping(value = "/users",method = RequestMethod.GET)
    // 查询所有员工
    public String usersList(Model model){
        List<User> allUser = userServiceImpl.findAll();
        model.addAttribute("users",allUser);
        System.out.println("正在进入用户列表界面");
        // 默认拼串，拼到classpath：/templates/ xxx.html
        return "user/list";
    }

    // 跳转到用户添加页面
    @GetMapping(value = "/user")
    public String toAddPage(){
        // // 查出员工信息
        // Collection<Department> departments = departmentDao.getDepartments();
        // // 歇会去
        // model.addAttribute("depts",departments);
        return "user/add";
    }


    // 添加员工
    // springMVC会将我们的请求参数和对应的javabean参数一一对应起来，所以叫做自动封装！！！1
    @PostMapping(value = "/user")
    public String addUsers(User user){

        System.out.println("保存的用户数据是"+user);
        //保存 用户数据
        int index = userServiceImpl.create(user);
        // c重定向
        // forward：转发到一个地址   /代表
        return "redirect:/users";
    }


    // 携带id去修改员工信息的页面
    @GetMapping(value = "/user/{account}")
    public String toEditPage(@PathVariable("account")String account, Model model){

        // 查到id的员工
        User user = userServiceImpl.findByAccount(account);
        // 回写回去
        System.out.println("员工account为"+account);
        model.addAttribute("user",user);

        // Collection<Department> departments = departmentDao.getDepartments();
        //
        // model.addAttribute("depts",departments);

        // add是修改添加二合一的页面
        return "user/add";

    }



    // 修改管理员信息
    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public String updataUser(User user){
        // 这里把传来的包括id和其他信息自动封装到employee里面，我们来查看是否修改完成
        System.out.println(user);
        // 保存
        int index = userServiceImpl.update(user);
        return "redirect:/users";
    }


    @PostMapping(value = "/user/{account}")
    public String deleteUser(@PathVariable("account")String account){
        System.out.println("要删除的员工account为:"+account);
        userServiceImpl.delete(account);
        return "redirect:/users";
    }




//    ---------------------------------前台-----------------------------------------









}
