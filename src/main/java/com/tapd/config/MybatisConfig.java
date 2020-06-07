package com.tapd.config;

import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;

/**
 * @Author jxd
 * @Date 2020-05-31  19:52
 * @Version 1.0
 */
// 自己配置mybatis的配置
@org.springframework.context.annotation.Configuration
public class MybatisConfig {

    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return new ConfigurationCustomizer() {

            @Override
            public void customize(Configuration configuration) {
                // 开启识别驼峰命名法！！！
                configuration.setMapUnderscoreToCamelCase(true);
            }
        };
    }
}
