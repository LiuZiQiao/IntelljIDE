package com.lxk.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Aspect
@Component
public class WebLogAspect {
    private Logger logger = Logger.getLogger(getClass());

    @Pointcut("execution(public * com.lxk.web.controller..*.*(..))")
    public void webLog() { }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //
        logger.info("---------request----------");
        logger.info("URL" + request.getRequestURL().toString());
        logger.info("---------request----------");
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        Enumeration<String> enu = request.getParameterNames();
        while (enu.hasMoreElements()) {
            String name = (String) enu.nextElement();
            logger.info("name:" + name + "value" + request.getParameter(name));
        }
    }

    @AfterReturning(returning = "ret",pointcut = "webLog()")
    public void doAfterReturning(Object ret){
        logger.info("---------response----------");
        logger.info("RESPONSE"+ret);
    }
}
