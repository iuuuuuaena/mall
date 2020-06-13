package com.tapd.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.tapd.config.AliPayConfig;
import com.tapd.enums.ResponseStatus;
import com.tapd.service.AliPayService;
import com.tapd.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author jxd
 * @Date 2020-06-07  07:43
 * @Version 1.0
 */
@RestController
public class AliPayController extends  BaseController {


    @Autowired
    @Qualifier("aliPayService")
    private AliPayService aliPayService;

    /**
     * web 订单支付
     */
    @GetMapping("/getPagePay")
    public Object getPagePay(
            @RequestParam("order_id")String order_id,
            @RequestParam(value = "order_price", required = false)int order_price,
            @RequestParam(value = "order_info", required = false)String order_info,
            HttpServletResponse httpResponse) throws Exception{
        // 调用web端支付服务

        System.out.println("appid为："+AliPayConfig.getAppId());
        System.out.println("order_id"+order_id);
        System.out.println("order_price"+order_price);
        System.out.println("order_info"+order_info);
        String pay = aliPayService.webPagePay(order_id,order_price,order_info);
        System.out.println(pay);
        if (pay == null){
            return ResultUtils.fail(ResponseStatus.ORDER_CREATE_FAIL);
        }else{
            Map<Object, Object> pays = new HashMap<>();
            pays.put("pay", pay);
            // httpResponse.setContentType("text/html;charset=" + AliPayConfig.getCHARSET());
            // httpResponse.getWriter().write(pay);//直接将完整的表单html输出到页面
            // httpResponse.getWriter().flush();
            // httpResponse.getWriter().close();
            return pays;
        }

    }





    /**
     * 交易查询
     */
    @PostMapping("/aliPayQuery")
    public Object aliPayQuery(@RequestParam("order_id")String order_id) throws Exception{

        String query = aliPayService.query(order_id);
        System.out.println(query);

        // JSONObject jsonObj = new JSONObject(query);
        // System.out.println(jsonObj);
        /*JSONObject jObject = new JSONObject();
        jObject.get(query);*/
        // Object json = JSONObject.toJSON(query);

        JSONObject jObject = new JSONObject();
        jObject.get(query);
        return ResultUtils.ok(jObject);
    }

    /**
     *  退款
     * @param order_id
     * @param refund_id
     * @param refund_price
     * @param refund_reason
     * @return
     * @throws AlipayApiException
     */
    @GetMapping("/aliPayRefund")
    public Object aliPayRefund(
            @RequestParam("order_id")String order_id,
            @RequestParam(value = "refund_id")String refund_id,
            @RequestParam(value = "refund_price")Integer refund_price,
            @RequestParam(value = "refund_reason", required = false)String refund_reason
    ) throws AlipayApiException {

        String refund = aliPayService.refund(order_id, refund_reason, refund_price,refund_id);

        System.out.println(refund);

        return ResultUtils.ok(refund);
    }

    /**
     * 退款查询
     * @throws AlipayApiException
     */
    @PostMapping("/refundQuery")
    public Object refundQuery(
            @RequestParam("order_id")String order_id,
            @RequestParam(value = "refund_id")String refund_id) throws AlipayApiException{

        String refund = aliPayService.refundQuery(order_id, refund_id);

        return ResultUtils.ok(refund);
    }

    /**
     * 交易关闭
     * @throws AlipayApiException
     */
    @PostMapping("/alipayclose")
    public Object alipaycolse(@RequestParam("order_id")String order_id) throws AlipayApiException{

        String close = aliPayService.close(order_id);

        return ResultUtils.ok(close);
    }



    /**
     * 支付异步通知
     * 接收到异步通知并验签通过后，一定要检查通知内容，
     * 包括通知中的app_id、out_trade_no、total_amount是否与请求中的一致，并根据trade_status进行后续业务处理。
     * https://docs.open.alipay.com/194/103296
     */
    @RequestMapping("/notify")
    public String notify(HttpServletRequest request) {
        // 验证签名
        boolean flag = aliPayService.rsaCheckV1(request);
        if (flag) {
            String tradeStatus = request.getParameter("trade_status"); // 交易状态
            String outTradeNo = request.getParameter("out_trade_no"); // 商户订单号
            String tradeNo = request.getParameter("trade_no"); // 支付宝订单号
            /**
             * 还可以从request中获取更多有用的参数，自己尝试
             */
            boolean notify = aliPayService.notify(tradeStatus, outTradeNo, tradeNo);
            if(notify){
                return "success";
            }
        }
        return "fail";
    }

}
