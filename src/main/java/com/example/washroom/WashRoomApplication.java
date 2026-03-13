package com.example.washroom;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
//@MapperScan("com.example.washroom.mapper")
public class WashRoomApplication {
    public static void main(String[] args) {
        SpringApplication.run(WashRoomApplication.class, args);
    }

}