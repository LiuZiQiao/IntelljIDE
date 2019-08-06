package com.lxk.thread;

public class test_类锁与对象锁的区别 extends Thread{
    public static int i = 0;
    public static int j = 0;
    public synchronized void inc(){
        i ++;
    }
    public static synchronized void incs(){
        j ++;
    }
    public void run() {
        for (int x = 0; x < 10; x++) {
            inc();
            incs();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        //不使用定线程池
        Thread[] t = new Thread[100];
        //创建子线程
        for (int i = 0; i < t.length; i++) {
            t[i] = new test_类锁与对象锁的区别();
        }
        //子线程开始
        for (int i = 0; i < t.length; i++) {
            t[i].start();
        }
        //join()方法的作用:让父线程等待子线程结束之后才能继续运行。
        for (int i = 0; i < t.length; i++) {
            t[i].join();
        }
        System.out.println("synchronized修饰非静态方法----"+test_类锁与对象锁的区别.i);
        System.out.println("synchronized修饰静态方法----"+test_类锁与对象锁的区别.j);
    }
}
