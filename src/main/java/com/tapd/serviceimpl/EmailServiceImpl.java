package com.tapd.serviceimpl;

import com.tapd.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

/**
 * @Author jxd
 * @Date 2020-06-05  12:16
 * @Version 1.0
 */
public class EmailServiceImpl implements EmailService {


    // 发送邮件的邮箱，我的邮箱
    @Value("${spring.mail.username}")
    private String from;

    // 邮件发送 API
    private JavaMailSender mailSender;

    Logger logger = LoggerFactory.getLogger(getClass());

    /**
     *  发送mail
     * @param to       到哪个邮箱
     * @param title    邮件标题
     * @param content  邮件内容
     */
    @Override
    public void sendSimpleMail(String to, String title, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(title);
        message.setText(content);
        mailSender.send(message);
        logger.info("邮件发送成功");
    }
}
