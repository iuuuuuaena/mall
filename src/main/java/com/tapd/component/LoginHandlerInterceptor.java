package com.tapd.component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author jxd
 * @Date 2020-05-15  17:47
 * @Version 1.0
 */

/**
 * 登录检查  拦截器
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {

    // 目标方法执行之前，
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("loginUser");
        if (user == null){
            // 未登录，返回主页面
            request.setAttribute("msg","没有权限");
            request.getRequestDispatcher("/index.html")
                    .forward(request,response);
            return false;
        }else{
            // 以登录
            return true;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
