package com.tapd.entities;

public class UPublishGoods {
    /*
    * user_id not null
    user_nickname null
    user_account not null 外 key
    goods_id 自增 not null key
    goods_name not null
    goods_amount not null
    goods_image not null
    goods_info not null
    goods_tag not null
    is_deal null
    */

    private Integer user_id;
    private String user_nickname;
    private String user_account;
    private String goods_id;
    private String goods_name;
    private String goods_account;
    private String goods_image;
    private String goods_info;
    private String goods_tag;
    private Integer is_deal;

    @Override
    public String toString() {
        return "User_publish_goods{" +
                "user_id=" + user_id +
                ", user_nickname='" + user_nickname + '\'' +
                ", user_account='" + user_account + '\'' +
                ", goods_id='" + goods_id + '\'' +
                ", goods_name=" + goods_name +
                ", goods_account='" + goods_account + '\'' +
                ", goods_image='" + goods_image + '\'' +
                ", goods_info='" + goods_info + '\'' +
                ", goods_tag='" + goods_tag + '\'' +
                ", is_deal='" + is_deal + '\'' +
                '}';
    }

    public Integer getUser_id() { return user_id; }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_nickname() { return user_nickname; }

    public void setUser_nickname(String user_nickname) {
        this.user_nickname = user_nickname;
    }

    public String getUser_account() { return user_account; }

    public void setUser_account(String user_account) {
        this.user_account = user_account;
    }

    public String getGoods_id() { return goods_id; }

    public void setGoods_id(String goods_id) {
        this.goods_id = goods_id;
    }

    public String getGoods_name() { return goods_name; }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }
    //goods_account
    public String getGoods_account() { return goods_account; }

    public void setGoods_account(String goods_account) {
        this.goods_account = goods_account;
    }
    //goods_image
    public String getGoods_image() { return goods_image; }

    public void setGoods_image(String goods_image) {
        this.goods_image = goods_image;
    }
    //goods_info
    public String getGoods_info() { return goods_info; }

    public void setGoods_info(String goods_info) {
        this.goods_info = goods_info;
    }
    //goods_tag
    public String getGoods_tag() { return goods_tag; }

    public void setGoods_tag(String goods_tag) {
        this.goods_tag = goods_tag;
    }
    //is_deal
    public Integer getIs_deal() { return is_deal; }

    public void setIs_deal(Integer is_deal) {
        this.is_deal = is_deal;
    }

    public UPublishGoods(Integer user_id, String user_nickname, String user_account, String goods_id, String goods_name,
                              String goods_account, String goods_image, String goods_info, String goods_tag, Integer is_deal)
    {
        this.user_id = user_id;
        this.user_nickname = user_nickname;
        this.user_account = user_account;
        this.goods_id = goods_id;
        this.goods_name = goods_name;
        this.goods_account = goods_account;
        this.goods_image = goods_image;
        this.goods_info = goods_info;
        this.goods_tag = goods_tag;
        this.is_deal = is_deal;
    }

}
