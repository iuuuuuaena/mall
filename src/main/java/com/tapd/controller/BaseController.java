package com.tapd.controller;

import com.tapd.POJO.UserLoginStatus;
import com.tapd.utils.CookieUtil;
import com.tapd.utils.JwtTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author jxd
 * @Date 2020-06-05  07:07
 * @Version 1.0
 */
public class BaseController {

    // 搞一个JwtToken
    protected JwtTokenUtils jwtTokenUtils;


    /**
     * 获取请求的token信息
     * @param request
     * @return
     */
    protected String getToken(HttpServletRequest request){
        // 从cookie中获取Authorization
        String token = CookieUtil.getCookie(request,"Authorization");
        if(token != null){
            return token;
        }
        // 如果cookie中没有的话，就从Header里获取
        return request.getHeader("Authorization");
    }

    /**
     * 从请求中获取用户登录状态
     * @param request
     * @return
     */
    protected UserLoginStatus getUserLoginStatus(HttpServletRequest request) {
        String token = getToken(request);
        // 判断token是否为空
        if(StringUtils.isEmptyOrWhitespace(token)){
            return null;
        }else{
            // 否则就从token中获取用户信息
            return jwtTokenUtils.getUserLoginStatusFromToken(token);
        }
    }

    @Autowired
    public void setJwtTokenUtil(JwtTokenUtils jwtTokenUtil) {
        this.jwtTokenUtils = jwtTokenUtil;
    }
}
