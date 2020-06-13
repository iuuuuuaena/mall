package com.tapd.enums;

// import jdk.nashorn.internal.objects.annotations.Getter;
/**
 * @Author jxd
 * @Date 2020-06-04  15:42
 * @Version 1.0
*/
public enum ResponseStatus {

    /**
     * 请求成功
     * */
    OK(200,"SUCCESS"),

    /**
     * 服务器异常
     * */
    ERROR(500,"未知异常，请联系管理员！"),

    /**
     * 参数错误
     * */
    PARAM_ERROR(400,"非法参数！"),


    /**
     * 拒绝访问
     * */
    FORBIDDEN(403,"拒绝访问！"),

    /**
     * 商品相关错误
     */

    NO_GOODS(600,"没有找到该商品"),
    GOODS_COLLECT_SUCCESS(601,"收藏商品成功"),
    GOODS_COLLECT_FAIL(602,"收藏商品失败"),
    GOODS_CANCEL_COLLECT_SUCCESS(603,"商品拿出购物车成功"),
    GOODS_CANCEL_COLLECT_FAIL(604,"商品拿出购物车失败"),
    HAS_COLLECT(605,"已经收藏过该商品了"),
    GOODS_PUBLISH_SUCCESS(606,"商品上传成功"),
    GOODS_PUBLISH_FAIL(607,"商品上传失败"),
    GOODS_DELETE_SUCCESS(608,"商品删除成功"),
    GOODS_DELETE_FAIL(609,"商品删除失败"),
    USER_DON_NO_HAVE_GOODS(610,"用户没有商品"),
    NO_IN_GOODS(611,"没有找id为这个的商品"),
    NO_GOODS_IN_THIS_ORDER(612,"该订单没有商品"),
    FIND_GOODS_IN_THIS_ORDER_SUCCESS(613,"订单的所有商品查询成功"),

    /**
     * 用户相关错误
     *
     * */
    NO_USER_OR_ACCOUNT_ERROR(1000,"不存在该用户，或者账号错误"),
    NO_LOGIN(1001, "未登录或登陆失败！"),
    VEL_CODE_ERROR(1002, "验证码不匹配！"),
    USER_EMAIL_EXIST(1003,"该邮箱已注册！"),
    USERNAME_PASS_ERROR(1004,"用户名或密码错误！"),
    OLD_PASSWORD_ERROR(1006,  "旧密码不匹配!"),
    REGISTER_ERROR(1008,"用户注册失败"),
    REGISTER_SUCCESS(1009,"用户注册成功"),
    HAS_LOGOUT(1010,"已经注销成功"),
    SUCCESS_LOGOUT(1011,"注销成功"),
    SUCCESS_LOGIN(1012,"登录成功"),
    ICON_CHANGE_FAIL(1013,"用户更新头像失败"),

    ICON_CHANGE_SUCCESS(1014,"用户更新头像成功"),
    USER_INFO_CHANGE_SUCCESS(1015,"用户信息更新成功"),
    USER_INFO_CHANGE_FAIL(1016,"用户信息更新失败"),

    /**
     * 评论相关错误
     * */
    DISCUSS_COMMENTS_SUCCESS(3000,"评论发表成功"),
    DISCUSS_COMMENTS_FAIL(3001,"评论发表失败"),
    DISCUSS_DELETE_SUCCESS(3002,"评论删除成功"),
    DISCUSS_DELETE_FAIL(3003,"评论删除失败"),
    DISCUSS_UPDATE_SUCCESS(3004,"评论修改成功"),
    DISCUSS_UPDATE_FAIL(3005,"评论修改失败"),
    HAS_COMMENTS(3006, "已评价过该商品！"),
    NO_BUY(3007,"没有购买该商品"),
    NO_DISCUSS(3008,"没有评论"),

    /**
     * 文件相关
     */
    IMG_UPLOAD_FAIL(4001,"图片上传失败"),
    IMG_UPLOAD_SUCCESS(4002,"图片上传成功"),
    IMG_UPDATE_SUCCESS(4003,"图片更新成功"),
    IMG_UPDATE_FAIL(4004,"图片更新失败"),


    /**
     * 商品相关错误
     */
    NO_ADMIN(5001,"需要管理员权限"),

    /**
     * 支付订单相关错误
     */

    ORDER_CREATE_SUCCESS(6000,"订单创建成功"),
    ORDER_CREATE_FAIL(6001,"订单创建失败"),
    BLANK_ORDER_NO(6002,"订单编号不能为空"),
    AMOUNT_LESS_THAN_0(6003,"退款金额必须大于0"),
    REFUND_FAIL(6004,"订单退款失败"),
    FAILED_GENERATE_ORDER(6005,"订单生成失败"),
    NO_THIS_ORDER_ID(6006,"没有这个订单"),
    ORDER_FIND_SUCCESS(6007,"订单查询成功"),
    CANCEL_ORDER_SUCCESS(6008,"取消订单成功"),
    CANCEL_ORDER_FAIL(6009,"取消订单失败"),
    TO_BE_PAID(6010, "待付款"),
    TO_BE_SHIPPED(6011, "待发货"),
    TO_BE_RECEIVED(6012, "待收货"),
    CANCEL(6013, "已取消"),
    FINISH(6014, "已完成"),
    REFUND_REQUEST(6015, "退款申请"),
    REFUND_SUCCESS(6016, "退款成功"),
    USER_ACCOUNT_NUT_NULL(6018,"用户账号不能为空"),
    NO_ORDER(6019,"没有订单"),



    /**
     * Code问题
     */

    NO_CODE(7000,"没有验证码，请先获取验证码!"),
    CODE_CHECK_SUCCESS(7001,"验证码检查成功"),
    CODE_GET_SUCCESS(7002,"验证码获取成功"),
    CODE_GET_ERROR(7003,"验证码获取错误"),


    /**
     * 收货地址问题
     *
     */


    USER_ACCOUNT_NOT_NULL(8848,"用户账号不能为空"),
    CREATE_ERROR(8849,"创建收货地址失败"),
    CREATE_SUCCESS(8850,"创建收货地址成功"),
    FIND_ADDRESS_FAIL(8851,"查找所有收货地址失败"),
    FIND_ADDRESS_SUCCESS(8852,"查找所有收货地址成功"),
    DELETE_ADDRESS_FAIL(8853,"删除收货地址失败"),
    DELETE_ADDRESS_SUCCESS(8854,"删除收货地址成功"),

    /**
     * 其他通用错误
     * */
    PASSWORD_ERROR(88001,"密码错误！");

    private int code;
    private String msg;

    @Override
    public String toString() {
        return "ResponseStatus{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    ResponseStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
