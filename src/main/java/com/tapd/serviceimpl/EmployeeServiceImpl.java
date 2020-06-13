package com.tapd.serviceimpl;

import com.tapd.POJO.Employee;

import com.tapd.mapper.EmployeeMapper;
import com.tapd.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author jxd
 * @Date 2020-06-01  12:41
 * @Version 1.0
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    public List<Employee> findAll() {
        return employeeMapper.showAllManager();
    }

    @Override
    public Employee findById(Integer id) {
        return employeeMapper.findById(id);
    }

    @Override
    public Employee findByAccount(String account) {
        return employeeMapper.findByAccount(account);
    }

    @Override
    public int create(Employee employee) {
        return employeeMapper.insert(employee);
    }

    @Override
    public int delete(String account) {
        return employeeMapper.deleteByAccount(account);
    }
    public int deleteById(int id) {
        return employeeMapper.deleteById(id);
    }

    @Override
    public int update(Employee employee) {
        return employeeMapper.update(employee);
    }


}
