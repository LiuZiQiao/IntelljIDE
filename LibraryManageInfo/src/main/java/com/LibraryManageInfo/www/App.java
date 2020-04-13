package com.LibraryManageInfo.www;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author xiaokun-liu
 * @version 1.0
 * @date 2020/4/10 20:32
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.LibraryManageInfo.www.*")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
}
