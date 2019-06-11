package com.lxk.web.controller;

import com.lxk.model.User;
import com.lxk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;
    @RequestMapping("register")
    @ResponseBody
    public String register(String username,String password){
        System.out.println(username+password);
        if(userService.Register(username,password)){
            return "success";
        }
        return "faild";
    }

    @RequestMapping("login")
    @ResponseBody
    public User login(String username){
      return userService.Login(username);
    }
}
