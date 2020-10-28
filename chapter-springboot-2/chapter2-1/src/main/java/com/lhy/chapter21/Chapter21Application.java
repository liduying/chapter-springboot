package com.lhy.chapter21;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lhy.chapter21.mapper")
public class Chapter21Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter21Application.class, args);
    }

}
