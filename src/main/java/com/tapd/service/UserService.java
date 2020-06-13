package com.tapd.service;

import com.tapd.POJO.User;
import com.tapd.POJO.UserLoginStatus;

/**
 * @Author jxd
 * @Date 2020-05-31  18:05
 * @Version 1.0
 */

public interface UserService extends BaseService<User> {

    UserLoginStatus loginStatusKeep(User user,String password); // 用户登录状态保持
    boolean isUserExist(String email); // 检查邮箱是否存在

    int updateImage(String user_account,String new_image);

    int update2(User user);



}

