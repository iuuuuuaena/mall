package com.tapd.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tapd.entities.User;
import com.tapd.entities.UserLoginStatus;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author jxd
 * @Date 2020-06-05  07:42
 * @Version 1.0
 */

@Component
public class JwtTokenUtils {


    /**
     * token有三部分组成 ：   第一部分我们称它为头部（header),
     * 第二部分我们称其为载荷（payload, 类似于飞机上承载的物品)，
     * 第三部分是签证（signature)
     * <p>
     * <p>
     * 参考：https://www.jianshu.com/p/576dbf44b2ae
     */

    private static final String CLAIM_KEY_USERNAME = "sub";   // sub: jwt所面向的用户
    private static final String CLAIM_KEY_CREATED = "created";

    // JWT的私钥
    @Value("${jwt.secret}")
    private String secret;

    // JWT的过期时间
    @Value("${jwt.expiration}")
    private Long expiration;


    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 根据负责生成JWT的token
     */
    private String generateToken(Map<String, Object> claims) {

        // 根据map信息生成token
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())  // 设置过期时间
                .signWith(SignatureAlgorithm.HS512, secret)   // 设置 签证信息
                .compact();
    }

    /**
     * 从token中获取JWT中的负载
     * <p>
     * <p>
     * Claim的意思是：要求，也就是里面的字段
     */
    private Claims getClaimsFromToken(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)  // 设置私钥
                    .parseClaimsJws(token)  // 解析token中的子曰
                    .getBody();
        } catch (Exception e) {
            logger.info("JWT格式验证失败:{}", token);
        }
        return claims;
    }

    /**
     * 生成token的过期时间
     */
    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }

    /**
     * 从token中获取用户信息
     */
    public UserLoginStatus getUserLoginStatusFromToken(String token) {

        // 判断token是否已经失效
        if (isTokenExpired(token)) {
            // 失效就表示用户状态没有登录
            return null;
        }
        // 不失效，还没过期，就新建
        UserLoginStatus userLoginStatus;
        try {
            // 从Token中获取的 json负载 字段
            Claims claims = getClaimsFromToken(token);

            // 把json转化为想要的格式，转化为我们的登录状态类
            userLoginStatus = new ObjectMapper().readValue(claims.getSubject(), UserLoginStatus.class);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            userLoginStatus = null;
        }
        return userLoginStatus;
    }


    /**
     * 判断token是否已经失效
     */
    private boolean isTokenExpired(String token) {
        // 从token中获取过期时间
        Date expiredDate = getExpiredDateFromToken(token);
        // 如果过期就返回true
        return expiredDate.before(new Date());
    }

    /**
     * 从token中获取过期时间
     */
    private Date getExpiredDateFromToken(String token) {
        Claims claims = getClaimsFromToken(token);
        return claims.getExpiration();
    }

    /**
     * 根据用户信息生成token
     */
    // @SneakyThrows
    public String generateToken(UserLoginStatus userLoginStatus) {
        Map<String, Object> claims = new HashMap<>(2);
        try {

            // 先把sub和这个登录状态信息放入
            claims.put(CLAIM_KEY_USERNAME, new ObjectMapper().writeValueAsString(userLoginStatus));
        } catch (JsonProcessingException e) {
            System.out.println("JwtTokenUTil的generateToken生成的Token有问题！");
            e.printStackTrace();
        }
        // 再把已创造和时间放入
        claims.put(CLAIM_KEY_CREATED, new Date());
        return generateToken(claims);
    }

    /**
     * 判断token是否可以被刷新
     */
    public boolean canRefresh(String token) {
        return !isTokenExpired(token);
    }

    /**
     * 刷新token
     */
    public String refreshToken(String token) {
        Claims claims = getClaimsFromToken(token);
        claims.put(CLAIM_KEY_CREATED, new Date());
        return generateToken(claims);
    }


}

