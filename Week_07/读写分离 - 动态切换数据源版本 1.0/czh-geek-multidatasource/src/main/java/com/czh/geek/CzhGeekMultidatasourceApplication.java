package com.czh.geek;

import com.czh.geek.datasource.DynamicDataSourceConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;

@MapperScan("com.czh.geek.mapper")
@Import({DynamicDataSourceConfig.class})
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class CzhGeekMultidatasourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CzhGeekMultidatasourceApplication.class, args);
    }

}
