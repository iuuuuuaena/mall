package com.tapd.serviceimpl;

import com.tapd.entities.User;
import com.tapd.entities.UserLoginStatus;
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

    public int deleteById(Integer id) {

        return userMapper.deleteByID(id);
    }

    @Override
    public int update(User user) {
        return userMapper.update(user);
    }

    /**
     * 保存用户状态
     * @param user
     * @param password
     * @return
     */
    @Override
    public UserLoginStatus loginStatusKeep(User user, String password) {
        // 如果用户输入的账号对应的密码与用户输入的密码不匹配的话
        if (!user.getUser_password().equals(password)) {
            // 返回null ，说明不能保持用户登录状态
            System.out.println("用户密码Wie："+user.getUser_password());
            System.out.println("输入的密码Wie："+password);
            return null;
        } else {
            // 如果相等，就说明，账号密码正确，即可以保存用户状态
            UserLoginStatus userLoginStatus = new UserLoginStatus();
            userLoginStatus.setUser_id(user.getUser_id());
            userLoginStatus.setUser_name(user.getUser_account());
            return userLoginStatus;
        }
    }


    /**
     * 判断用户是否登录
     * @param email
     * @return
     */
    @Override
    public boolean isUserExist(String email) {
        List<User> userByEmail = userMapper.findUserByEmail(email);
        if (userByEmail.size() == 0) return false;
        else return true;
    }
}
