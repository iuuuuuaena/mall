package com.tapd.utils;

/**
 * @Author jxd
 * @Date 2020-06-05  07:05
 * @Version 1.0
 */
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Administrator
 */
public class CookieUtil {

    // 获取cookie
    /**
     *
     * @param request   请求
     * @param key       获取哪个cookie的值
     * @return
     */
    public static String getCookie(HttpServletRequest request,String key){
        Cookie[] cookies = request.getCookies();
        if(cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(key)) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
    // 设置cookie
    public static void setCookie(HttpServletResponse response,String key,String value){
        Cookie cookie = new Cookie(key, value);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

}
