package com.tapd.service;

import com.tapd.entities.User;
import com.tapd.entities.UserLoginStatus;
import com.tapd.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author jxd
 * @Date 2020-05-31  18:05
 * @Version 1.0
 */

public interface UserService extends BaseService<User> {

    public UserLoginStatus loginStatusKeep(User user,String password); // 用户登录状态保持
    public boolean isUserExist(String email); // 检查邮箱是否存在

}

