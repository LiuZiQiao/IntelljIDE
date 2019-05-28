package com.lxk.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MyTask {

    @Scheduled(initialDelay = 1000,fixedDelay = 1000)
    public void firstTask(){
        System.out.println("MyTask:"+new Date()+"这是第一个任务");
    }
    @Scheduled(cron = "*/5 * * * * ?")
    public void secondTask(){
        System.out.println("MyTask:"+new Date()+"这是第二个任务");
    }
}
