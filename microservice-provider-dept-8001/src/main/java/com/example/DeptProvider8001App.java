package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Djh
 */
@EnableEurekaClient
@MapperScan(basePackages = {"com.example.dao"})
@SpringBootApplication
@EnableDiscoveryClient
public class DeptProvider8001App {

    public static void main(String[] args) {

        SpringApplication.run(DeptProvider8001App.class, args);
    }
}
