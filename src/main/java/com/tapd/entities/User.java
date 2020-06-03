package com.tapd.entities;

/**
 * @Author jxd
 * @Date 2020-05-31  18:07
 * @Version 1.0
 */
public class User {
    //user_id	not null
    // user_nickname	null
    // user_account	not null key
    //user_password	not null
    // user_age	null
    // user_gender	null
    // user_hobby	null
    // user_icon	null
    // user_qq	null
    // user_card	null
    // all_deal_amount

    private Integer user_id;
    private String user_nickname;
    private String user_account;
    private String user_password;
    private Integer user_age;
    private Integer user_gender;
    private String user_hobby;
    private String user_icon;
    private String user_qq;
    private String user_card;
    private Integer all_deal_amount;
    private String user_email;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_nickname() {
        return user_nickname;
    }

    public void setUser_nickname(String user_nickname) {
        this.user_nickname = user_nickname;
    }

    public String getUser_account() {
        return user_account;
    }

    public void setUser_account(String user_account) {
        this.user_account = user_account;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public Integer getUser_age() {
        return user_age;
    }

    public void setUser_age(Integer user_age) {
        this.user_age = user_age;
    }

    public Integer getUser_gender() {
        return user_gender;
    }

    public void setUser_gender(Integer user_gender) {
        this.user_gender = user_gender;
    }

    public String getUser_hobby() {
        return user_hobby;
    }

    public void setUser_hobby(String user_hobby) {
        this.user_hobby = user_hobby;
    }

    public String getUser_icon() {
        return user_icon;
    }

    public void setUser_icon(String user_icon) {
        this.user_icon = user_icon;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_nickname='" + user_nickname + '\'' +
                ", user_account='" + user_account + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_age=" + user_age +
                ", user_gender=" + user_gender +
                ", user_hobby='" + user_hobby + '\'' +
                ", user_icon='" + user_icon + '\'' +
                ", user_qq='" + user_qq + '\'' +
                ", user_card='" + user_card + '\'' +
                ", all_deal_amount=" + all_deal_amount +
                ", user_email='" + user_email + '\'' +
                '}';
    }

    public String getUser_qq() {
        return user_qq;
    }

    public void setUser_qq(String user_qq) {
        this.user_qq = user_qq;
    }

    public String getUser_card() {
        return user_card;
    }

    public void setUser_card(String user_card) {
        this.user_card = user_card;
    }

    public Integer getAll_deal_amount() {
        return all_deal_amount;
    }

    public void setAll_deal_amount(Integer all_deal_amount) {
        this.all_deal_amount = all_deal_amount;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public User(Integer user_id, String user_nickname, String user_account, String user_password, Integer user_age, Integer user_gender, String user_hobby, String user_icon, String user_qq, String user_card, Integer all_deal_amount, String user_email) {
        this.user_id = user_id;
        this.user_nickname = user_nickname;
        this.user_account = user_account;
        this.user_password = user_password;
        this.user_age = user_age;
        this.user_gender = user_gender;
        this.user_hobby = user_hobby;
        this.user_icon = user_icon;
        this.user_qq = user_qq;
        this.user_card = user_card;
        this.all_deal_amount = all_deal_amount;
        this.user_email = user_email;
    }
}


