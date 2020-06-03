package com.tapd.controller;

import com.tapd.entities.Employee;
import com.tapd.serviceimpl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author jxd
 * @Date 2020-05-15  18:38
 * @Version 1.0
 */
@Controller
// 处理查询所有管理员的请求
public class EmployeeController {


    @Autowired
    EmployeeServiceImpl employeeServiceImpl;



    /**
     *  跳转到员工界面，并查询所有员工显示在页面上
     *  */
    @GetMapping(value = "/managers")
    public String usersList(Model model){
        // 获取所有员工信息
        List<Employee> allManager = employeeServiceImpl.findAll();
        model.addAttribute("managers",allManager);
        // 默认拼串，拼到classpath：/templates/ xxx.html
        return "manager/list";
    }

    /**
     *  到员工的部门到页面，做下拉列表框
     * @param
     * @return
     */
    @GetMapping(value = "/manager")
    public String toAddPage(){
        // // 查出员工信息
        // Collection<Department> departments = departmentDao.getDepartments();
        // // 歇会去
        // model.addAttribute("depts",departments);

        return "manager/add";
    }

    /**
     *  添加员工
     *  springMVC会将我们的请求参数和对应的javabean参数一一对应起来，所以叫做自动封装！！！1
     * @param employee
     * @return
     */
    @PostMapping(value = "/manager")
    public String addManagers(Employee employee){

        System.out.println("保存的用户数据是"+employee);
        //保存 用户数据
        employeeServiceImpl.create(employee);
        // c重定向
        // forward：转发到一个地址   /代表
        return "redirect:/managers";
    }


    /**
     * 携带account去修改员工信息的页面
     * @param account
     * @param model
     * @return
     */
    @GetMapping(value = "/manager/{account}")
    public String toEditPage(@PathVariable("account")String account, Model model){

        // 查到id的员工
        Employee emp = employeeServiceImpl.findByAccount(account);
        // 回写回去
        model.addAttribute("manager",emp );
        System.out.println("要修改的员工是！"+emp);

        // Collection<Department> departments = departmentDao.getDepartments();
        //
        // model.addAttribute("depts",departments);

    // add是修改添加二合一的页面
        return "manager/add";

}


    /**
     * 修改员工信息
     * @param employee
     * @return
     */
    @PutMapping(value = "/manager")
    public String updataUser(Employee employee){
        // 这里把传来的包括id和其他信息自动封装到employee里面，我们来查看是否修改完成
        System.out.println("更新这个用户："+employee);
        // 保存
        employeeServiceImpl.update(employee);
        return "redirect:/managers";
    }


    /**
     * 根据员工account删除员工
     * @param account
     * @return
     */
    @PostMapping(value = "/manager/{account}")
    public String deleteUser(@PathVariable("account")String account){
        System.out.println("要删除的员工account为:"+account);
        employeeServiceImpl.delete(account);
        return "redirect:/managers";
    }




}
