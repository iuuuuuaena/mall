package com.tapd.POJO;

/**
 * @Author jxd
 * @Date 2020-06-09  08:48
 * @Version 1.0
 */
public class Refund {

    private Integer refund_id;
    private String order_id;
    private String order_info;
    private Integer refund_price;
    private String refund_reason;

    @Override
    public String toString() {
        return "Refund{" +
                "refund_id=" + refund_id +
                ", order_id='" + order_id + '\'' +
                ", order_info='" + order_info + '\'' +
                ", refund_price=" + refund_price +
                ", refund_reason='" + refund_reason + '\'' +
                '}';
    }

    public Integer getRefund_id() {
        return refund_id;
    }

    public void setRefund_id(Integer refund_id) {
        this.refund_id = refund_id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getOrder_info() {
        return order_info;
    }

    public void setOrder_info(String order_info) {
        this.order_info = order_info;
    }

    public Integer getRefund_price() {
        return refund_price;
    }

    public void setRefund_price(Integer refund_price) {
        this.refund_price = refund_price;
    }

    public String getRefund_reason() {
        return refund_reason;
    }

    public void setRefund_reason(String refund_reason) {
        this.refund_reason = refund_reason;
    }

    public Refund(Integer refund_id, String order_id, String order_info, Integer refund_price, String refund_reason) {
        this.refund_id = refund_id;
        this.order_id = order_id;
        this.order_info = order_info;
        this.refund_price = refund_price;
        this.refund_reason = refund_reason;
    }
}
