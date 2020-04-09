package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author xiaokun-liu
 * @version 1.0
 * @date 2020/4/8 21:08
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.curd.*")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
