package com.tapd.utils;

/**
 * @Author jxd
 * @Date 2020-06-04  16:09
 * @Version 1.0
 */

import com.tapd.enums.ResponseStatus;

import java.io.Serializable;

public class ResultUtils<T> implements Serializable {


    private static final long serialVersionUID = 1L;

    private int code ;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public ResultUtils() {
    }

    public ResultUtils(T data) {
        this.data = data;
    }


    public ResultUtils(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    /**
     * 响应消息
     */
    private String msg ;
    /**
     * 响应中的数据
     */
    private T data;


    /**
     * 业务处理成功,无数据返回
     */
    public static ResultUtils ok() {
        return new ResultUtils();
    }


    /**
     * 业务处理成功，有数据返回
     */
    public static <T> ResultUtils ok(T data) {
        return new ResultUtils(data);
    }
    public static <T> ResultUtils ok(int code, String msg,T data) {
        return new ResultUtils(code, msg, data);
    }

    /**
     * 业务处理失败
     */
    public static ResultUtils fail(ResponseStatus responseStatus) {
        return new ResultUtils(responseStatus);
    }

    public static ResultUtils fail(int code, String msg) {
        return new ResultUtils(code, msg, null);
    }

    public static <T> ResultUtils fail(int code, String msg,T data) {
        return new ResultUtils(code, msg, data);
    }

    /**
     * 系统错误
     */
    public static ResultUtils error() {
        return new ResultUtils(ResponseStatus.ERROR);
    }

    public static ResultUtils error(int code, String msg) {
        return new ResultUtils(code, msg, null);
    }
    public static <T> ResultUtils error(int code, String msg,T data) {
        return new ResultUtils(code, msg, data);
    }

    // public static ResultUtils error(ResponseStatus ResponseStatus) {
    //     return new ResultUtils(ResponseStatus);


    // }

    public static <T> ResultUtils error(T data) {
        return new ResultUtils(data);
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultUtils{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

}


