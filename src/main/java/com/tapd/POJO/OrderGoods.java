package com.tapd.POJO;

import java.sql.Date;

/**
 * @Author jxd
 * @Date 2020-06-09  08:43
 * @Version 1.0
 */
public class OrderGoods {

    private String order_id;
    private String user_account;
    private Integer goods_id;
    private String goods_name;
    private String goods_image;
    private Integer goods_number;
    private Integer goods_price;

    public String getOrder_id() {
        return order_id;
    }

    @Override
    public String toString() {
        return "OrderGoods{" +
                "order_id='" + order_id + '\'' +
                ", user_account='" + user_account + '\'' +
                ", goods_id=" + goods_id +
                ", goods_name='" + goods_name + '\'' +
                ", goods_image='" + goods_image + '\'' +
                ", goods_number=" + goods_number +
                ", goods_price=" + goods_price +
                '}';
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

    public Integer getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Integer goods_id) {
        this.goods_id = goods_id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getGoods_image() {
        return goods_image;
    }

    public void setGoods_image(String goods_image) {
        this.goods_image = goods_image;
    }

    public Integer getGoods_number() {
        return goods_number;
    }

    public void setGoods_number(Integer goods_number) {
        this.goods_number = goods_number;
    }

    public Integer getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(Integer goods_price) {
        this.goods_price = goods_price;
    }

    public OrderGoods(String order_id, String user_account, Integer goods_id, String goods_name, String goods_image, Integer goods_number, Integer goods_price) {
        this.order_id = order_id;
        this.user_account = user_account;
        this.goods_id = goods_id;
        this.goods_name = goods_name;
        this.goods_image = goods_image;
        this.goods_number = goods_number;
        this.goods_price = goods_price;
    }
}
