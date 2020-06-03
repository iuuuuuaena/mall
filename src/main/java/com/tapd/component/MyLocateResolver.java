package com.tapd.component;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @Author jxd
 * @Date 2020-05-15  17:02
 * @Version 1.0
 */
// 适用这个component来实现自己点击链接进行国际化切换语言
// 可以在连接上携带区域信息！1
public  class MyLocateResolver implements LocaleResolver {
    @Override
    // 解析区域信息！！
    public Locale resolveLocale(HttpServletRequest request) {
        String l = request.getParameter("l");
        // 如果带区域信息，就用自己的
        // ，不带就用默认的
        Locale locale = Locale.getDefault();
        if (!StringUtils.isEmpty(l)){
            String[] split = l.split("_");
            locale = new Locale(split[0], split[1]);
        }
        return locale;
    }
    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }


}
