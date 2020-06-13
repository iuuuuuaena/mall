package com.tapd.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author jxd
 * @Date 2020-06-07  07:30
 * @Version 1.0
 */
@Component
@ConfigurationProperties(prefix = "alipay")
public class AliPayConfig {


/**   https://openclub.alipay.com/club/history/read/1909

 invalid-app-id（无效的AppID）参数问题自查方案
 *
 */


    //  应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号

    public static String APP_ID = "";

    // 商户私钥，您的PKCS8格式RSA2私钥，这些就是我们刚才设置的
    public static String MERCHANT_PRIVATE_KEY ="";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。，这些就是我们刚才设置的
    public static String ALIPAY_PUBLIC_KEY= "";

    // 异步通知，再这里我们设计自己的后台代码
    public static String notify_url = "http://mall.jxdgogogo.xyz/order";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://mall.jxdgogogo.xyz/order";

    // 签名方式
    public static String SIGN_TYPE = "RSA2";

    // 字符编码格式
    public static String CHARSET = "utf-8";

    public static String getAppId() {
        return APP_ID;
    }

    public static void setAppId(String appId) {
        APP_ID = appId;
    }

    public static String getMerchantPrivateKey() {
        return MERCHANT_PRIVATE_KEY;
    }

    public static void setMerchantPrivateKey(String merchantPrivateKey) {
        MERCHANT_PRIVATE_KEY = merchantPrivateKey;
    }

    public static String getAlipayPublicKey() {
        return ALIPAY_PUBLIC_KEY;
    }

    public static void setAlipayPublicKey(String alipayPublicKey) {
        ALIPAY_PUBLIC_KEY = alipayPublicKey;
    }

    public static String getNotify_url() {
        return notify_url;
    }

    public static void setNotify_url(String notify_url) {
        AliPayConfig.notify_url = notify_url;
    }

    public static String getReturn_url() {
        return return_url;
    }

    public static void setReturn_url(String return_url) {
        AliPayConfig.return_url = return_url;
    }

    public static String getSignType() {
        return SIGN_TYPE;
    }

    public static void setSignType(String signType) {
        SIGN_TYPE = signType;
    }

    public static String getCHARSET() {
        return CHARSET;
    }

    public static void setCHARSET(String CHARSET) {
        AliPayConfig.CHARSET = CHARSET;
    }

    public static String getGATEWAYURL() {
        return GATEWAYURL;
    }

    public static void setGATEWAYURL(String GATEWAYURL) {
        AliPayConfig.GATEWAYURL = GATEWAYURL;
    }

    public static String getLogPath() {
        return LOG_PATH;
    }

    public static void setLogPath(String logPath) {
        LOG_PATH = logPath;
    }

    public AliPayConfig() {
    }
// 支付宝网关

    public static String GATEWAYURL="https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String LOG_PATH = "/";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(LOG_PATH + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
