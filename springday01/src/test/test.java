package test;

import com.lxk.service.UserService;
import com.lxk.service.UserServiceimpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    @Test
    public void test1()
    {
        //以前使用service的方法，自己创建对象
//        UserService userService = new UserServiceimpl();
//        userService.add();
        //现在的方法

        //加载beans.xml 这个spring配置文件，会创建对象
        ApplicationContext context = new ClassPathXmlApplicationContext("/beans.xml");
        //从spring中获取userService对象
        UserService userService = (UserService) context.getBean("userService");
        userService.add();
    }
}
