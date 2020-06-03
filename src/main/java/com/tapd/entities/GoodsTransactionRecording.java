package com.tapd.entities;

public class GoodsTransactionRecording {
    private Integer goods_id;
    private String goods_name;
    private String goods_account;
    private Integer is_deal;

    @Override
    public String toString() {
        return "Goods_transaction_recording{" +
                ", goods_id='" + goods_id + '\'' +
                ", goods_name=" + goods_name +
                ", goods_account='" + goods_account + '\'' +
                ", is_deal='" + is_deal + '\'' +
                '}';
    }

    public Integer getGoods_id() { return goods_id; }

    public void setGoods_id(Integer goods_id) {
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

    //is_deal
    public Integer getIs_deal() { return is_deal; }

    public void setIs_deal(Integer is_deal) {
        this.is_deal = is_deal;
    }

    public GoodsTransactionRecording(Integer goods_id, String goods_name, String goods_account, Integer is_deal)
    {
        this.goods_id = goods_id;
        this.goods_name = goods_name;
        this.goods_account = goods_account;
        this.is_deal = is_deal;
    }
}
