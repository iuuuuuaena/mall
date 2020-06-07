package com.tapd.enums;

// import jdk.nashorn.internal.objects.annotations.Getter;
/**
 * @Author jxd
 * @Date 2020-06-04  15:42
 * @Version 1.0
*/
// @Getter
// @AllArgsConstructor
// @NoArgsConstructor
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
    /**
     * 用户相关错误
     *
     * */
    NO_USER_OR_ACCOUNT_ERROR(1000,"不存在该用户，或者账号错误"),
    NO_LOGIN(1001, "未登录或登陆失败！"),
    VEL_CODE_ERROR(1002, "验证码不匹配！"),
    USER_EMAIL_EXIST(1003,"该邮箱已注册！"),
    USERNAME_PASS_ERROR(1004,"用户名或密码错误！"),
    TWO_PASSWORD_DIFF(1005, "两次输入的新密码不匹配!"),
    OLD_PASSWORD_ERROR(1006,  "旧密码不匹配!"),
    REGISTER_ERROR(1008,"用户注册失败"),
    REGISTER_SUCCESS(1009,"用户注册成功"),
    HAS_LOGOUT(1010,"已经注销成功"),
    SUCCESS_LOGOUT(1011,"注销成功"),

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
     * 支付相关错误
     */
    BLANK_ORDER_NO(6001,"订单编号不能为空"),
    AMOUNT_LESS_THAN_0(6002,"退款金额必须大于0"),
    REFUND_FAIL(6003,"订单退款失败"),
    FAILED_GENERATE_ORDER(6004,"订单生成失败"),


    /**
     * Code问题
     */

    NO_CODE(7000,"没有验证码，请先获取验证码!"),
    CODE_CHECK_SUCCESS(7001,"验证码检查成功"),
    CODE_GET_SUCCESS(7002,"验证码获取成功"),
    CODE_GET_ERROR(7003,"验证码获取错误"),


    /**
     * 其他通用错误
     * */
    PASSWORD_ERROR(88001,"密码错误！");

    private int code;
    private String msg;


    ResponseStatus() {
    }

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
