package com.tapd.POJO;

import java.sql.Date;

public class Order {
    private String order_id;
    private String user_account;
    private String order_info;
    private Integer order_price;
    private Date order_date;
    private Integer order_status;  // 订单状态： 0 ： 订单已销毁
                                   //           1 ： 订单交易成功

    @Override
    public String toString() {
        return "Order{" +
                "order_id='" + order_id + '\'' +
                ", user_account='" + user_account + '\'' +
                ", order_info='" + order_info + '\'' +
                ", order_price=" + order_price +
                ", order_date=" + order_date +
                ", order_status=" + order_status +
                '}';
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getUser_account() {
        return user_account;
    }

    public void setUser_account(String user_account) {
        this.user_account = user_account;
    }

    public String getOrder_info() {
        return order_info;
    }

    public void setOrder_info(String order_info) {
        this.order_info = order_info;
    }

    public Integer getOrder_price() {
        return order_price;
    }

    public void setOrder_price(Integer order_price) {
        this.order_price = order_price;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public Integer getOrder_status() {
        return order_status;
    }

    public void setOrder_status(Integer order_status) {
        this.order_status = order_status;
    }

    public Order(String order_id, String user_account, String order_info, Integer order_price, Date order_date, Integer order_status) {
        this.order_id = order_id;
        this.user_account = user_account;
        this.order_info = order_info;
        this.order_price = order_price;
        this.order_date = order_date;
        this.order_status = order_status;
    }
}
