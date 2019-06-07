package com.binzikeji.spring.shiro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.binzikeji.spring.shiro.mapper")
public class SpringShiroApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringShiroApplication.class, args);
    }

}
