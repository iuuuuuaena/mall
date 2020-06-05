package com.tapd.entities;

import java.util.Date;

public class Employee {

	private Integer manager_id;
    private String manager_nickname;
    private String manager_account;
    private String manager_password;
    private String manager_icon;
    private String manager_email;
    private Integer all_deal_amount;

    @Override
    public String toString() {
        return "Employee{" +
                "manager_id=" + manager_id +
                ", manager_nickname='" + manager_nickname + '\'' +
                ", manager_account='" + manager_account + '\'' +
                ", manager_password='" + manager_password + '\'' +
                ", manager_icon='" + manager_icon + '\'' +
                ", manager_email='" + manager_email + '\'' +
                ", all_deal_amount=" + all_deal_amount +
                '}';
    }

    public Integer getManager_id() {
        return manager_id;
    }

    public void setManager_id(Integer manager_id) {
        this.manager_id = manager_id;
    }

    public String getManager_nickname() {
        return manager_nickname;
    }

    public void setManager_nickname(String manager_nickname) {
        this.manager_nickname = manager_nickname;
    }

    public String getManager_account() {
        return manager_account;
    }

    public void setManager_account(String manager_account) {
        this.manager_account = manager_account;
    }

    public String getManager_password() {
        return manager_password;
    }

    public void setManager_password(String manager_password) {
        this.manager_password = manager_password;
    }

    public String getManager_icon() {
        return manager_icon;
    }

    public void setManager_icon(String manager_icon) {
        this.manager_icon = manager_icon;
    }

    public String getManager_email() {
        return manager_email;
    }

    public void setManager_email(String manager_email) {
        this.manager_email = manager_email;
    }

    public Integer getAll_deal_amount() {
        return all_deal_amount;
    }

    public void setAll_deal_amount(Integer all_deal_amount) {
        this.all_deal_amount = all_deal_amount;
    }

    public Employee(Integer manager_id, String manager_nickname, String manager_account, String manager_password, String manager_icon, String manager_email, Integer all_deal_amount) {
        this.manager_id = manager_id;
        this.manager_nickname = manager_nickname;
        this.manager_account = manager_account;
        this.manager_password = manager_password;
        this.manager_icon = manager_icon;
        this.manager_email = manager_email;
        this.all_deal_amount = all_deal_amount;
    }
}
