package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author Djh
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class DeptConsumer80App {

    public static void main(String[] args) {

        SpringApplication.run(DeptConsumer80App.class, args);
    }
}
