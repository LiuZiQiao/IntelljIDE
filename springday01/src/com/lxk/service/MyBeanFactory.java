package com.lxk.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyBeanFactory {
    public static UserService createUserService()
    {
        final UserService userService = new UserServiceimpl();
        System.out.println(userService);
        final MyAspectJ myAspectJ = new MyAspectJ();

        UserService userProxyService1 = (UserService) Proxy.newProxyInstance(
               MyBeanFactory.class.getClassLoader(),
               userService.getClass().getInterfaces(),
               new InvocationHandler(){
                   @Override
                   public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                       myAspectJ.before();
                       Object obj = method.invoke(userService,args);
                       System.out.println(obj);
                       myAspectJ.after();
                       return obj;
                   }
               }
        );
        return userProxyService1;
    }
}
