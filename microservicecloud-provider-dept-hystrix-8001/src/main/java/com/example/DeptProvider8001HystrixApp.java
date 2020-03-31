package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Djh
 */
@EnableEurekaClient
@SpringBootApplication
@MapperScan(basePackages = {"com.example.dao"})
@EnableDiscoveryClient
@EnableCircuitBreaker
public class DeptProvider8001HystrixApp {

    public static void main(String[] args) {

        SpringApplication.run(DeptProvider8001HystrixApp.class, args);
    }
}
