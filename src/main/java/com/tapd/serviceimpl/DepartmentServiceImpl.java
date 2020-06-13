package com.tapd.serviceimpl;

import com.tapd.POJO.Department;
import com.tapd.mapper.DepartmentMapper;
import com.tapd.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author jxd
 * @Date 2020-06-01  11:40
 * @Version 1.0
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {


    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public List<Department> findAll() {
        return null;
    }

    @Override
    public Department findById(Integer id) {
        return departmentMapper.findById(id);
    }

    @Override
    public Department findByAccount(String account) {
        return null;
    }

    @Override
    public int create(Department department) {
        return 0;
    }

    @Override
    public int delete(String user_account) {
        return 0;
    }

    @Override
    public int update(Department department) {
        return 0;
    }
}
