package com.tapd;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
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
