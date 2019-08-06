package com.lxk.thread;

/*
懒汉式单例在多线程下的问题
：
 */

public class LazySingleton {
    private LazySingleton(){
        try{
            Thread.sleep(50);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("生成LazySingleton实例一次");
    }

    private  static LazySingleton lazyInstance = null;
    public static LazySingleton getLazyInstance(){
        if (lazyInstance == null){
            synchronized (LazySingleton.class){
                if (lazyInstance == null){
                    lazyInstance = new LazySingleton();
                }
            }
        }
        return  lazyInstance;
    }

//    public static LazySingleton getLazyInstance(){
//        if (lazyInstance == null) {
//            lazyInstance = new LazySingleton();
//        }
//        return  lazyInstance;
//    }
}
