package com.tapd.entities;

import javax.swing.*;

/**
 * @Author jxd
 * @Date 2020-06-03  15:57
 * @Version 1.0
 */
public class Goods {

    private String user_nickname;
    private String user_account;
    private Integer goods_id;
    private String goods_name;
    private String goods_amount;
    private String goods_image;
    private String goods_info;
    private String goods_tag;
    private Integer is_deal;

    @Override
    public String toString() {
        return "Goods{" +
                "user_nickname='" + user_nickname + '\'' +
                ", user_account='" + user_account + '\'' +
                ", goods_id=" + goods_id +
                ", goods_name='" + goods_name + '\'' +
                ", goods_amount='" + goods_amount + '\'' +
                ", goods_image='" + goods_image + '\'' +
                ", goods_info='" + goods_info + '\'' +
                ", goods_tag='" + goods_tag + '\'' +
                ", is_deal=" + is_deal +
                '}';
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

    public String getGoods_amount() {
        return goods_amount;
    }

    public void setGoods_amount(String goods_amount) {
        this.goods_amount = goods_amount;
    }

    public String getGoods_image() {
        return goods_image;
    }

    public void setGoods_image(String goods_image) {
        this.goods_image = goods_image;
    }

    public String getGoods_info() {
        return goods_info;
    }

    public void setGoods_info(String goods_info) {
        this.goods_info = goods_info;
    }

    public String getGoods_tag() {
        return goods_tag;
    }

    public void setGoods_tag(String goods_tag) {
        this.goods_tag = goods_tag;
    }

    public Integer getIs_deal() {
        return is_deal;
    }

    public void setIs_deal(Integer is_deal) {
        this.is_deal = is_deal;
    }

    public Goods(String user_nickname, String user_account, Integer goods_id, String goods_name, String goods_amount, String goods_image, String goods_info, String goods_tag, Integer is_deal) {
        this.user_nickname = user_nickname;
        this.user_account = user_account;
        this.goods_id = goods_id;
        this.goods_name = goods_name;
        this.goods_amount = goods_amount;
        this.goods_image = goods_image;
        this.goods_info = goods_info;
        this.goods_tag = goods_tag;
        this.is_deal = is_deal;
    }
}
