package com.LibraryManageInfo.www.controller;

import com.LibraryManageInfo.www.entitys.User;
import com.LibraryManageInfo.www.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.logging.Logger;

/**
 * @author xiaokun-liu
 * @version 1.0
 * @date 2020/4/10 19:08
 */
@Controller
public class UserController {
    private static final Logger LOG = Logger.getLogger(String.valueOf(UserController.class));

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/hello")
    @ResponseBody
    public String hello() {
        System.out.println("hello...");
        return "hello,springboot 我来了";
    }

    @RequestMapping(value = "/")
    public String index2(){
        return "login";
    }

    @RequestMapping(value = "/index")
    public String index(){
        System.out.println("idddd");
        return "index";
    }

    @RequestMapping(value = "/regist_page")
    public String regist(){
        return "regist";
    }

    @RequestMapping(value = "/regist")
    public String regist(User user, HttpServletRequest request){
        LOG.info("regist----"+user);
        int num = userService.regist(user);
        if (num>0){
            return "login";
        }
        request.setAttribute("regist_error","注册失败，请重新注册");
        return "regist";
    }

    @RequestMapping(value = "/login_page")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/login")
    public String login(User user, HttpServletRequest request, HttpSession session){
        LOG.info("login-----"+user);
        user = userService.login(user);
        if (user!=null && user.getUserid()>0){
            session.setAttribute("user",user);
        }
        request.setAttribute("login_error","登录失败，请重新登录");

        return "index";   //登录成功进入图书主页
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "login";
    }
}
