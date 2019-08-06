package com.lxk.thread;

/*
饿汉式：

应用刚启动的时候，不管外部有没有调用该类的实例方法，该类的实例就已经创建好了。（空间换时间。）

优点：写法简单，在多线程下也能保证单例实例的唯一性，不用同步，运行效率高。

缺点：在外部没有使用到该类的时候，该类的实例就创建了，若该类实例的创建比较消耗系统资源，并且外部一直没有调用该实例，那么这部分的系统资源的消耗是没有意义的。
 */

public class Singleton {

    private Singleton(){}

    private static final Singleton instance = new Singleton();
    public static Singleton getInstance(){
        return instance;
    }
}
