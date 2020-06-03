package com.tapd.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Author jxd
 * @Date 2020-06-03  12:39
 * @Version 1.0
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    // 重写方法  授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //     首页可以访问，其他页面必须有权限的才能访问
        //    链式编程


        // 请求授权的规则！！！
        //首页可以访问
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/index").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/user/**").hasRole("employee")
                .antMatchers("/manager/**").hasRole("manager");

        // 没有权限就转发到登录界面
        http.formLogin();
    }


    /**
     * 认证
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // 我们需要把密码编码
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("root").password(new BCryptPasswordEncoder().encode("123456")).roles("manager","employee")
                .and()
                .withUser("admin").password(new BCryptPasswordEncoder().encode("123456")).roles("employee");


    }
}
