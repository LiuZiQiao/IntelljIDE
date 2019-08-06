package com.lxk.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class test_类锁与对象锁_解决方案 {
    public static int i = 0;
    public static int j = 0;

    //synchronized修饰非静态方法
    public synchronized void function() throws InterruptedException {
        i++;
    }

    //synchronized修饰静态方法
    public static synchronized void staticFunction()
            throws InterruptedException {
        j++;
    }

    public static void main(String[] args) {
        final test_类锁与对象锁_解决方案 demo = new test_类锁与对象锁_解决方案();
        //使用定长线程池
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    staticFunction();
                    demo.function();
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        for (int i = 0; i < 1000; i++) {
            fixedThreadPool.execute(t1);
        }
        fixedThreadPool.shutdown();
        while (true) {
            if (fixedThreadPool.isTerminated()) {
                System.out.println("synchronized修饰非静态方法----" + test_类锁与对象锁_解决方案.i);
                System.out.println("synchronized修饰静态方法----" + test_类锁与对象锁_解决方案.j);
                break;
            }
        }
    }
}
