package com.example.h2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author freedom
 */
@MapperScan("com.example.h2.dao")
@SpringBootApplication
public class H2Application {
    public static void main(String[] args) {
        SpringApplication.run(H2Application.class, args);
    }
}
