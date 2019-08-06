package com.lxk.thread;

/*
    1. 当synchronized修饰一个static方法时，多线程下，获取的是类锁（即Class本身，注意：不是实例），作用范围是整个静态方法，作用的对象是这个类的所有对象。
    2. 当synchronized修饰一个非static方法时，多线程下，获取的是对象锁（即类的实例对象），作用范围是整个方法，作用对象是调用该方法的对象。
    结论：类锁和对象锁不同，他们之间不会产生互斥。
 */


public class SynchoronizedDemo {

    //synchronized修饰非静态方法
    public synchronized void function() throws InterruptedException {
        for (int i = 0; i <3; i++) {
            Thread.sleep(1000);
            System.out.println("function running...");
        }
    }
    //synchronized修饰静态方法
    public static synchronized void staticFunction()
            throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            Thread.sleep(1000);
            System.out.println("Static function running...");
        }
    }

    public static void main(String[] args) {
        final SynchoronizedDemo demo = new SynchoronizedDemo();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    staticFunction();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    demo.function();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
    }
}