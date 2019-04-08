package test;

import com.lxk.model.Person;
import com.lxk.model.User;
import com.lxk.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Lesson {
    @Test
    public void test1()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans2.xml");
//        User user = (User) context.getBean("user");
//        System.out.println(user);
        Person person = (Person)context.getBean("person");
//        person.setName("zhangsan");
//        person.setAge(20);

        System.out.println(person.getName()+":"+person.getAge());
    }
}
