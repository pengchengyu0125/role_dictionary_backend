package com.rbc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@MapperScan("com.rbc.mapper")
@SpringBootApplication
public class RoleDictionaryManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(RoleDictionaryManageApplication.class, args);
    }
}
