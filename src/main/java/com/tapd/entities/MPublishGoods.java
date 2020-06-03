package com.tapd.entities;

public class MPublishGoods {
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

    private Integer manager_id;
    private String manager_nickname;
    private String manager_account;
    private Integer goods_id;
    private String goods_name;
    private String goods_account;
    private String goods_image;
    private String goods_info;
    private String goods_tag;
    private Integer is_deal;

    @Override
    public String toString() {
        return "MPublishGoods{" +
                "manager_id=" + manager_id +
                ", manager_nickname='" + manager_nickname + '\'' +
                ", manager_account='" + manager_account + '\'' +
                ", goods_id=" + goods_id +
                ", goods_name='" + goods_name + '\'' +
                ", goods_account='" + goods_account + '\'' +
                ", goods_image='" + goods_image + '\'' +
                ", goods_info='" + goods_info + '\'' +
                ", goods_tag='" + goods_tag + '\'' +
                ", is_deal=" + is_deal +
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

    public String getGoods_account() {
        return goods_account;
    }

    public void setGoods_account(String goods_account) {
        this.goods_account = goods_account;
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

    public MPublishGoods(Integer manager_id, String manager_nickname, String manager_account, Integer goods_id, String goods_name, String goods_account, String goods_image, String goods_info, String goods_tag, Integer is_deal) {
        this.manager_id = manager_id;
        this.manager_nickname = manager_nickname;
        this.manager_account = manager_account;
        this.goods_id = goods_id;
        this.goods_name = goods_name;
        this.goods_account = goods_account;
        this.goods_image = goods_image;
        this.goods_info = goods_info;
        this.goods_tag = goods_tag;
        this.is_deal = is_deal;
    }
}
