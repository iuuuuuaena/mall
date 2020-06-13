package com.tapd.serviceimpl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePagePayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.*;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.tapd.POJO.Order;
import com.tapd.config.AliPayConfig;
import com.tapd.mapper.OrderMapper;
import com.tapd.service.AliPayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author jxd
 * @Date 2020-06-07  07:33
 * @Version 1.0
 */
@Service("aliPayService")
public class AliPayServiceImpl  implements AliPayService {


    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    AliPayConfig aliPayConfig;


    OrderMapper orderMapper;

    @Autowired
    public void setOrderMapper(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    /** 调取支付宝接口 web端支付*/
    DefaultAlipayClient alipayClient = new DefaultAlipayClient(
            AliPayConfig.GATEWAYURL, AliPayConfig.APP_ID, AliPayConfig.MERCHANT_PRIVATE_KEY, "json", AliPayConfig.CHARSET, AliPayConfig.ALIPAY_PUBLIC_KEY, AliPayConfig.SIGN_TYPE);

    /**
     *
     * @param order_id    订单编号（唯一）
     * @param order_price 订单价格
     * @param order_info  商品名称
     * @return
     * @throws Exception
     */
    @Override
    public String webPagePay(String order_id, Integer order_price, String order_info) throws Exception {

        //SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
        AlipayTradePagePayModel model = new AlipayTradePagePayModel();
        model.setSubject(order_info);
        model.setOutTradeNo(order_id);
        model.setTotalAmount(String.valueOf(order_price));
        model.setProductCode("FAST_INSTANT_TRADE_PAY");//QUICK_WAP_PAY
//        model.setPassbackParams("公用回传参数，如果请求时传递了该参数，则返回给商户时会回传该参数");

        //实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
        AlipayTradePagePayRequest ali_request = new AlipayTradePagePayRequest();
        ali_request.setBizModel(model);
       ali_request.setReturnUrl(AliPayConfig.getReturn_url());// 回调地址
        ali_request.setNotifyUrl(AliPayConfig.getNotify_url());// 回调地址
        AlipayTradePagePayResponse ali_response = alipayClient.pageExecute(ali_request);//"GET"直接获取URL



       // AlipayTradePagePayResponse ali_response = alipayClient.pageExecute(ali_request,"GET");
        //就是orderString 可以直接给客户端请求，无需再做处理。
        return ali_response.getBody();
    }



    /**
     *
     * @param order_id      订单编号
     * @param refund_reason 退款原因
     * @param refund_price  退款金额
     * @param refund_id     标识一次退款请求，同一笔交易多次退款需要保证唯一，如需部分退款，则此参数必传
     * @return
     * @throws AlipayApiException
     */
    @Override
    public String refund(String order_id, String refund_reason, Integer refund_price, String refund_id) throws AlipayApiException {
        AlipayTradeRefundRequest alipayRequest = new AlipayTradeRefundRequest();

        /** 调取接口*/
        alipayRequest.setBizContent("{\"out_trade_no\":\""+ order_id +"\","
                        + "\"refund_amount\":\"" + refund_price + "\","
                        + "\"refund_reason\":\"" + refund_reason + "\","
                        + "\"out_request_no\":\""+ refund_id +"\"}");

        String result = alipayClient.execute(alipayRequest).getBody();
        return result;

    }

    /**
     *
     * @param order_id 订单编号（唯一）
     * @return
     * @throws AlipayApiException
     */
    @Override
    public String query(String order_id) throws AlipayApiException {

        // AlipayTradePagePayModel model = new AlipayTradePagePayModel();
        // model.setOutTradeNo(order_id);

        AlipayTradeQueryRequest alipayRequest = new AlipayTradeQueryRequest();
        // alipayRequest.setBizModel(model);
        /**请求接口*/
        alipayRequest.setBizContent("{\"out_trade_no\":\""+ order_id +"\","+"\"trade_no\":\""+ "" +"\"}");
        /**转换格式*/
        String result = alipayClient.execute(alipayRequest).getBody();
        return result;

    }


    /**
     *
     * @param order_id 订单编号（唯一）
     * @return
     * @throws AlipayApiException
     */
    @Override
    public String close(String order_id) throws AlipayApiException {
        AlipayTradeCloseRequest alipayRequest = new AlipayTradeCloseRequest();

        alipayRequest.setBizContent("{\"out_trade_no\":\""+ order_id +"\"," +"\"trade_no\":\""+ "" +"\"}");

        String result = alipayClient.execute(alipayRequest).getBody();

        return result;

    }

    /**
     *
     * @param order_id     订单编号（唯一）
     * @param refund_id 标识一次退款请求，同一笔交易多次退款需要保证唯一，如需部分退款，则此参数必传
     * @return
     * @throws AlipayApiException
     */
    @Override
    public String refundQuery(String order_id, String refund_id) throws AlipayApiException {
        AlipayTradeFastpayRefundQueryRequest alipayRequest = new AlipayTradeFastpayRefundQueryRequest();

        /** 请求接口*/
        alipayRequest.setBizContent("{\"out_trade_no\":\""+ order_id +"\","
                +"\"out_request_no\":\""+ refund_id +"\"}");

        /** 格式转换*/
        String result = alipayClient.execute(alipayRequest).getBody();
        return result;
    }

    @Override
    public boolean rsaCheckV1(HttpServletRequest request){
        try {
            Map<String, String> params = new HashMap<>();
            Map<String, String[]> requestParams = request.getParameterMap();
            for (String name : requestParams.keySet()) {
                String[] values = requestParams.get(name);
                String valueStr = "";
                for (int i = 0; i < values.length; i++) {
                    valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
                }
                params.put(name, valueStr);
            }

            boolean verifyResult = AlipaySignature.rsaCheckV1(params, aliPayConfig.getAlipayPublicKey(), aliPayConfig.getCHARSET(), aliPayConfig.getSignType());
            return verifyResult;
        } catch (AlipayApiException e) {
            logger.debug("verify sign in error, exception is:", e);
            return false;
        }
    }



    /**
     * 支付异步通知
     * 接收到异步通知并验签通过后，一定要检查通知内容，
     * 包括通知中的app_id、out_trade_no、total_amount是否与请求中的一致，并根据trade_status进行后续业务处理。
     * https://docs.open.alipay.com/194/103296
     */
    @Override
    public boolean notify(String tradeStatus, String order_id, String tradeNo) {
        if ("TRADE_FINISHED".equals(tradeStatus) || "TRADE_SUCCESS".equals(tradeStatus)) {
            // 支付成功，根据业务逻辑修改相应数据的状态
//             boolean state = orderPaymentService.updatePaymentState(orderNo, tradeNo);
            Order order=orderMapper.findByOrderId(order_id);
            if (order==null)return false;
            // 设置订单状态
            int result = orderMapper.setOrderSuccessByOrderId(order.getOrder_id());
            return result == 1;
        }
        return false;
    }


}
