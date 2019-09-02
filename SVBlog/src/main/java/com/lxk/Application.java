package com.lxk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.swing.plaf.metal.MetalTheme;

@SpringBootApplication
@EnableScheduling //开启定时任务支持
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
