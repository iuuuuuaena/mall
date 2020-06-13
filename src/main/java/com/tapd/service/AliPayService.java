package com.tapd.service;


import com.alipay.api.AlipayApiException;
import org.apache.ibatis.annotations.ResultMap;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author jxd
 * @Date 2020-06-07  07:31
 * @Version 1.0
 */
public interface AliPayService {


    /**
     * web端订单支付
     *
     * @param order_id    订单编号（唯一）
     * @param order_price 订单价格
     * @param order_info  商品名称
     */
    String webPagePay(String order_id, Integer order_price, String order_info) throws Exception;


    /**
     * 退款
     *
     * @param order_id      订单编号
     * @param refund_reason 退款原因
     * @param refund_price  退款金额
     * @param refund_id     标识一次退款请求，同一笔交易多次退款需要保证唯一，如需部分退款，则此参数必传
     */
    String refund(String order_id, String refund_reason, Integer refund_price, String refund_id) throws AlipayApiException;

    /**
     * 交易查询
     *
     * @param order_id 订单编号（唯一）
     */
    String query(String order_id) throws AlipayApiException;

    /**
     * 交易关闭
     *
     * @param order_id 订单编号（唯一）
     */
    String close(String order_id) throws AlipayApiException;

    /**
     * 退款查询
     *
     * @param order_id     订单编号（唯一）
     * @param refund_id 标识一次退款请求，同一笔交易多次退款需要保证唯一，如需部分退款，则此参数必传
     */
    String refundQuery(String order_id  , String refund_id ) throws AlipayApiException;


    /**
     * 校验
     * @param request
     * @return
     */
    boolean rsaCheckV1(HttpServletRequest request);


    /**
     *
     * @param tradeStatus
     * @param orderNo
     * @param tradeNo
     * @return
     */
    boolean notify(String tradeStatus, String orderNo, String tradeNo);



}

