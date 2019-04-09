package com.lxk.aspectj;

public class MyAspectJ {
    public void before()
    {
        System.out.println("开启事物");
    }
    public void after()
    {
        System.out.println("关闭事物");
    }
}
