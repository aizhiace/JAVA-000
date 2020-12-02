package com.czh.geek;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.czh.geek.mapper")
@SpringBootApplication
public class CzhGeekSqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(CzhGeekSqlApplication.class, args);
    }

}
