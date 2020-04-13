package com.lxk.spring.servlet;

import com.lxk.spring.annotation.MyController;
import com.lxk.spring.annotation.MyService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;

public class MyDispatcherServlet extends HttpServlet {

    private Properties properties = new Properties();
    private List<String> classNames = new ArrayList<String>();
    private Map<String,Object> ioc = new HashMap<String,Object>();
    @Override
    public void init(ServletConfig config) throws ServletException {
        doLoadConfig(config.getInitParameter("contextConfigLocation"));
        doScanner(properties.getProperty("packName"));
        doInstance();
        doAutowried();
        InitHandlerMapping();
    }

    private void doScanner(String packName) {
        URL url = this.getClass().getClassLoader().getResource("/"+packName.replaceAll("\\.","/"));
        File classDir = new File(url.getFile());
        for (File file: classDir.listFiles()) {
            if (file.isDirectory()){
                doScanner(packName+"."+file.getName());
            }else{
                    String className = (packName+"."+file.getName().replace(".class",""));
                    classNames.add(className);
            }
        }
    }

    private void doAutowried() {
    }

    private void InitHandlerMapping() {
    }

    private void doInstance() {
        if (classNames.isEmpty()){return;}
        try {
        for (String c: classNames) {
            Class<?> clazz = Class.forName(c);


//            IOC 容器规则
//            1.key默认用类名首字母小写
//            2.如果用户自定义名字，优先选择自定义名字

              if (clazz.isAnnotationPresent(MyController.class)){
                    String bean = lowerFirstCase(clazz.getSimpleName());
                    ioc.put(bean,clazz.newInstance());
              }else if(clazz.isAnnotationPresent(MyService.class)) {
//                    3.如果是接口的话利用接口类型作为key
                  MyService service = clazz.getAnnotation(MyService.class);
                  String beanName = service.value();
                  if ("".equals(beanName.trim())) {
                      beanName = lowerFirstCase(clazz.getSimpleName());
                  }
                  Object instance = clazz.newInstance();
                  ioc.put(beanName,instance);

                  Class<?>[] interfaces = clazz.getInterfaces();
                  for (Class<?> i: interfaces) {
                      ioc.put(i.getName(),instance);
                  }
              }else {
                  continue;
              }
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String lowerFirstCase(String str){
        char [] chars = str.toCharArray();
        chars[0] +=32;
        return String.valueOf(chars);
    }

    private void doLoadConfig(String config) {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(config);
        try{
            properties.load(is);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(null != is){
                try {
                    is.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }


}
