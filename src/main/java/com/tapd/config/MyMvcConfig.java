package com.tapd.config;

import com.tapd.component.LoginHandlerInterceptor;
import com.tapd.component.MyLocateResolver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import javax.servlet.MultipartConfigElement;

/**
 * @Author jxd
 * @Date 2020-05-13  13:50
 * @Version 1.0
 */
// 配置类 ,使用@Configuration来 标注这是一个配置类
// 使用 WebMvcConfigurer  来扩展我们的配置类 ，扩展至SpringMVC的功能

// @EnableWebMvc   不要全部接管SpringMVC
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {


    // 视图映射，直接把某个请求映射到某个页面
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        // 视图映射，把/hello请求映射到index，浏览器访问hello，会映射到到index
        registry.addViewController("/login").setViewName("login.html");
        registry.addViewController("/index").setViewName("login.html");
        registry.addViewController("/register").setViewName("register.html");
    }
    //
    // // 注册拦截器
    // @Override
    // public void addInterceptors(InterceptorRegistry registry) {
    //     // 不能把所有的都拦截了，把我们的css 都留下来
    //     registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
    //             .excludePathPatterns("/index.html", "/manager/login", "/webjars/**", "/assert/**", "/login", "/manager/**", "/user", "/users/**", "/managers", "/manageradd"
    //                     , "/department", "/department/**", "/show", "/hello", "/users","/mall/**","/register.html","/register","/user/**");
    // }

    @Bean
    public WebMvcConfigurerAdapter webMvcAutoConfigurationAdapter() {
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/login").setViewName("login");
                registry.addViewController("/login.html").setViewName("login");
                registry.addViewController("/index").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                // 把main.html映射到dashboard页面
                registry.addViewController("/main.html").setViewName("dashboard");
                registry.addViewController("/register").setViewName("register");
            }
        };
        return adapter;
    }

    // 国际化：让浏览器用我们的自己写的localeresolver
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocateResolver();
    }


    // websocket的配制，多人聊天
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }


    @Value("${user.file.path}")
    private String filePath;

    // 配置文件上传路径
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // // registry.addResourceHandler("/asserts/img/**").addResourceLocations("file:D:/temp-rainy/");
        // String os = System.getProperty("os.name");
        //
        // if (os.toLowerCase().startsWith("win")) {  //如果是Windows系统
        //     // /Users/mac/大学学习整理/java/managementplatform2/src/main/resources/static/asserts
        //     registry.addResourceHandler("/file/**")
        //             // /apple/**表示在磁盘apple目录下的所有资源会被解析为以下的路径
        //             .addResourceLocations("/asserts/**") //媒体资源
        //             .addResourceLocations("classpath:/META-INF/resources/static/asserts/");  //swagger2页面
        // } else {  //linux 和mac
        //     registry.addResourceHandler("/file/**")
        //             .addResourceLocations("/asserts/**")   //媒体资源
        //             .addResourceLocations("classpath/META-INF/resources/static/asserts/");  //swagger2页面;
        // }
        // 注意如果filePath是写死在这里，一定不要忘记尾部的/或者\\，这样才能读取其目录下的文件
        registry.addResourceHandler("/**").addResourceLocations("" +
                        "classpath:/META-INF/resources/",
                "classpath:/resources/",
                "classpath:/static/",
                "classpath:/public/",
                "file:/" + filePath,
                "classpath:/webapp/");

    }

    //
    // /**
    //  * 添加配置目录
    //  * @return
    //  */
    // @Bean
    // MultipartConfigElement multipartConfigElement() {
    //     MultipartConfigFactory factory = new MultipartConfigFactory();
    //     factory.setLocation(filePath);
    //     return factory.createMultipartConfig();
    // }


    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*"); //允许任何域名
        corsConfiguration.addAllowedHeader("*"); //允许任何头
        corsConfiguration.addAllowedMethod("*"); //允许任何方法
        return corsConfiguration;
    }

    // @Bean
    // public CorsFilter corsFilter() {
    //     UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    //     source.registerCorsConfiguration("/**", buildConfig()); //注册
    //     return new CorsFilter(source);
    // }



}
