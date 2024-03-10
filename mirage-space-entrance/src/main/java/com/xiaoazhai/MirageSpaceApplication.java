package com.xiaoazhai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xiaoazhai.dao.mapper")

public class MirageSpaceApplication {
    //启动 Spring Boot 应用
    public static void main(String[] args) {
        SpringApplication.run(MirageSpaceApplication.class, args);
    }
}
