package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@MapperScan(basePackages = {"com.example.dao"})
@SpringBootApplication
public class DeptProvider8001_App {

    public static void main(String[] args) {

        SpringApplication.run(DeptProvider8001_App.class, args);
    }
}
