package com.tapd;

import org.junit.jupiter.api.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import javax.sql.DataSource;
import java.sql.SQLException;


@SpringBootTest
class ManagementplatformApplicationTests {


    // @Autowired
    // DataSource dataSource;
    // @Test
    // public void test() throws SQLException {
    //     System.out.println(dataSource.getClass());
    //
    //     dataSource.getConnection();
    // }


    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void test1(){

        // trace跟踪信息！！
        logger.trace("这是跟踪信息");
        // 调试信息
        logger.debug("这是调试信息");

        logger.info("12345");
    }




}
