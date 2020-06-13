package com.tapd.POJO;

/**
 * @Author jxd
 * @Date 2020-06-05  07:08
 * @Version 1.0
 */
public class UserLoginStatus {
    private Integer user_id;
    private String user_name;

    @Override
    public String toString() {
        return "UserLoginStatus{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                '}';
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public UserLoginStatus() {
    }

    public UserLoginStatus(Integer user_id, String user_name) {
        this.user_id = user_id;
        this.user_name = user_name;
    }
}
