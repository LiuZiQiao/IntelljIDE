package com.lxk.thread;

import java.util.concurrent.ExecutorService;

public class Main {

//    public static void main(String[] args) {
//	// write your code here
//        for (int i=0;i<10;i++){
//            new Thread(){
//                @Override
//                public void run() {
//                    LazySingleton.getLazyInstance();
//                }
//            }.start();
//        }
//    }

    public static void main(String[] args) {
        ExecutorService threadPoolFactoryUtil = ThreadPoolFactoryUtil.getUtil().getExecutorService();
        for (int i=0;i<10;i++){
            final int index = i;
            threadPoolFactoryUtil.execute(new Runnable() {
                @Override
                public void run() {
                   try{
                       String threadName = Thread.currentThread().getName();
                       System.out.println("执行："+index+",线程："+threadName);
                       Thread.sleep(3000);
                       System.out.println("----------------------");
                   }catch (InterruptedException e){
                       e.printStackTrace();
                   }
                }
            });
        }
    }
}
