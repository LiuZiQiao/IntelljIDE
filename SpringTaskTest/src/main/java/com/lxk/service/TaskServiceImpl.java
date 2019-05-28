package com.lxk.service;

import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

public class TaskServiceImpl implements TaskService {

    @Scheduled(initialDelay = 1000,fixedDelay = 1000)
    public void FirstTask() {
        System.out.println(new Date() + "第一个任务");
    }

//    @Scheduled(initialDelay = 2000,fixedDelay = 3000)
    @Scheduled(cron = "0 45 15 * * ?")
    public void SecondTask() {
        System.out.println(new Date() + "第二个任务");
    }
}
