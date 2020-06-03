package com.tapd.entities;

/**
 * @Author jxd
 * @Date 2020-06-02  22:03
 * @Version 1.0
 */
public class Discuss {
    private String user_account;
    private String user_nickname;
    private Integer discuss_id;
    private String discuss_content;

    @Override
    public String toString() {
        return "Discuss{" +
                "user_account='" + user_account + '\'' +
                ", user_nickname='" + user_nickname + '\'' +
                ", discuss_id=" + discuss_id +
                ", discuss_content='" + discuss_content + '\'' +
                '}';
    }

    public String getUser_account() {
        return user_account;
    }

    public void setUser_account(String user_account) {
        this.user_account = user_account;
    }

    public String getUser_nickname() {
        return user_nickname;
    }

    public void setUser_nickname(String user_nickname) {
        this.user_nickname = user_nickname;
    }

    public Integer getDiscuss_id() {
        return discuss_id;
    }

    public void setDiscuss_id(Integer discuss_id) {
        this.discuss_id = discuss_id;
    }

    public String getDiscuss_content() {
        return discuss_content;
    }

    public void setDiscuss_content(String discuss_content) {
        this.discuss_content = discuss_content;
    }

    public Discuss(String user_account, String user_nickname, Integer discuss_id, String discuss_content) {
        this.user_account = user_account;
        this.user_nickname = user_nickname;
        this.discuss_id = discuss_id;
        this.discuss_content = discuss_content;
    }
}
