package com.lxk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.lxk.web.controller","com.lxk.service"})
@MapperScan(basePackages = {"com.lxk.mapper"})
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
}
