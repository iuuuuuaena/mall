package com.tapd.service;


import com.tapd.POJO.Employee;

/**
 * @Author jxd
 * @Date 2020-06-01  12:40
 * @Version 1.0
 */
public interface EmployeeService extends BaseService<Employee>{

    public int deleteById(int id);
}
