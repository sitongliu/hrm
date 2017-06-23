package com.hrm.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2017/6/16.
 */
@Configuration
@AutoConfigureAfter(MyBatisConfig.class)
public class MyBatisMapperScannerConfig {

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapper=new MapperScannerConfigurer();
        mapper.setBasePackage("com.hrm.mapper");
        mapper.setSqlSessionFactoryBeanName("sqlSessionFactory");
        return mapper;
    }
}
