package com.community;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.community.dao")
@SpringBootApplication
public class CommunityApplication {

    public static void main(String[] args) {
        System.out.println("hello world");
        SpringApplication.run(CommunityApplication.class, args);
    }

}
