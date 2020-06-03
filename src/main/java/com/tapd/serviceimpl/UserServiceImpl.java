package com.tapd.serviceimpl;

import com.tapd.entities.User;
import com.tapd.mapper.UserMapper;
import com.tapd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author jxd
 * @Date 2020-06-01  08:54
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;


    @Override
    public List<User> findAll() {
        return userMapper.showAllUser();
    }

    @Override
    public User findById(Integer id) {
        System.out.println("userid = " + id);
        // System.out.println("用户为" + userMapper.findById(id));
        return userMapper.findById(id);
    }

    @Override
    public User findByAccount(String account) {
        return userMapper.findByAccount(account);
    }

    @Override
    public int create(User user) {
        System.out.println("插入" + user);
        return userMapper.insert(user);
    }

    @Override
    public int delete(String user_name) {

        return userMapper.deleteByAccount(user_name);
    }

    @Override
    public int update(User user) {
        return userMapper.update(user);
    }
}
