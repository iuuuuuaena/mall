package com.tapd.service;

/**
 * @Author jxd
 * @Date 2020-06-05  12:16
 * @Version 1.0
 */
public interface EmailService {

    public void sendSimpleMail(String to, String title, String content);
}
