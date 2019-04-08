package test;

import com.lxk.model.Person;
import com.lxk.service.MyBeanFactory;
import com.lxk.service.UserService;
import com.lxk.service.UserServiceimpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LessonAop {
    @Test
    public void test1()
    {
        UserService userService = new UserServiceimpl();
        userService.add();
        userService.delete();
    }

    //使用自己写的一个AOP编程
    @Test
    public void test2()
    {
        UserService userService = MyBeanFactory.createUserService();
        userService.add();
        userService.delete();
    }
}
