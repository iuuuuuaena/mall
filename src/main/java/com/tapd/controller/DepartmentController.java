package com.tapd.controller;

import com.tapd.POJO.Department;
import com.tapd.serviceimpl.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author jxd
 * @Date 2020-05-31  20:30
 * @Version 1.0
 */
@Controller
public class DepartmentController {



    @Autowired
    DepartmentServiceImpl departmentServiceImpl;


    @ResponseBody
    @RequestMapping("/department/{id}")
    public Department findById(@PathVariable("id")Integer id){
        System.out.println(id);
        return departmentServiceImpl.findById(id);
    }

}
