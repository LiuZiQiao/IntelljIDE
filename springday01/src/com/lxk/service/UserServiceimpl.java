package com.lxk.service;

public class UserServiceimpl implements UserService{
    private String name;

    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return  name;
    }
    @Override
    public void add(){
        System.out.println("创建用户。。。"+getName());
    }

    @Override
    public int delete() {
        System.out.println("删除用户。。。");
        return 0;
    }
}
