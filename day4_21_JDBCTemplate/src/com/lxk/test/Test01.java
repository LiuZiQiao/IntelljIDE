package com.lxk.test;

import com.lxk.dao.UserDao;
import com.lxk.dao.UserDaoImpl;
import com.lxk.model.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
    @Test
    public void test()
    {

        ApplicationContext context = new ClassPathXmlApplicationContext("bean01.xml");
        UserDao u = new  UserDaoImpl();
        User user = new User();
        user.setUserName("张三");
        user.setPassword("123456");

        UserDaoImpl ud = (UserDaoImpl) context.getBean("userDao");
        ud.add(user);
    }
}
