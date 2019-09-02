package com.lxk.controller;

import com.lxk.bean.RespBean;
import com.lxk.bean.User;
import com.lxk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginRegController {
    @Autowired
    UserService userService;

    @RequestMapping("/login_error")
    public RespBean loginError(){
        return new RespBean("error","登陆失败");
    }

    @RequestMapping("/login_success")
    public RespBean loginSuccess(){
        System.out.println("--------/login_success---------");
        return new RespBean("success","登录成功");
    }

    @RequestMapping("/login_page")
    public RespBean loginPage() {
        return new RespBean("error", "尚未登录，请登录!");
    }
    @RequestMapping("/register")
    public RespBean reg(User user) {
        int result = userService.reg(user);
        if (result == 0) {
            //成功
            return new RespBean("success", "注册成功!");
        } else if (result == 1) {
            return new RespBean("error", "用户名重复，注册失败!");
        } else {
            //失败
            return new RespBean("error", "注册失败!");
        }
    }
}
