package com.lxk.thread;

public class GracefulSingleton {
    private GracefulSingleton(){
        System.out.println("创建GracefulSingleton实例一次");
    }
    private static class SingletonHoder{
        private static  GracefulSingleton instance = new GracefulSingleton();
    }
    public static GracefulSingleton getInstance(){
        return SingletonHoder.instance;
    }
}
