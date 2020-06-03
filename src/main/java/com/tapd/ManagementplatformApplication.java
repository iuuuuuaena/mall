package com.tapd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// SpringBoot启动类
@SpringBootApplication
// @MapperScan("com.tapd.mapper")
public class ManagementplatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManagementplatformApplication.class, args);
    }
}
