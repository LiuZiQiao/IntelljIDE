package com.lxk.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolFactoryUtil {

    private ExecutorService executorService;
    //在构造函数总创建线程池
    private ThreadPoolFactoryUtil(){
        //获取系统处理器个数，作为线程数
        int nThreads = Runtime.getRuntime().availableProcessors();
        System.out.println("nThread:"+nThreads);
        executorService = Executors.newFixedThreadPool(nThreads);
    }

    //定义一个静态内部类，内部定义静态成员变量创建外部类实例
    private static class SingletonContainer{
        private static ThreadPoolFactoryUtil util = new ThreadPoolFactoryUtil();
    }
    //获取本类对象
    public static ThreadPoolFactoryUtil getUtil(){
        return SingletonContainer.util;
    }

    public ExecutorService getExecutorService(){
        return executorService;
    }
}
