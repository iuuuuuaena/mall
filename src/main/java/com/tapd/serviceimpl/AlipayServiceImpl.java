package com.tapd.serviceimpl;

import com.alipay.api.AlipayApiException;
import com.tapd.service.AlipayService;
import org.apache.ibatis.annotations.ResultMap;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author jxd
 * @Date 2020-06-07  07:33
 * @Version 1.0
 */
public class AlipayServiceImpl  implements AlipayService {

    @Override
    public String createOrder(String orderNo, double amount, String body) throws AlipayApiException {
        return null;
    }

    @Override
    public boolean notify(String tradeStatus, String orderNo, String tradeNo) {
        return false;
    }

    @Override
    public boolean rsaCheckV1(HttpServletRequest request) {
        return false;
    }

    @Override
    public ResultMap refund(String orderNo, double amount, String refundReason) {
        return null;
    }
}
