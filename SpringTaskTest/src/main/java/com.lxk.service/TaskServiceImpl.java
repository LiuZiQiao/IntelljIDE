package com.lxk.service;

import java.util.Date;

public class TaskServiceImpl implements TaskService {
    public void FirstTask() {
        System.out.println(new Date() + "第一个任务");
    }

    public void SecondTask() {
        System.out.println(new Date() + "第二个任务");
    }
}
