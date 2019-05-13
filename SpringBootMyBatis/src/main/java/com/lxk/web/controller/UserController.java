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
    @RequestMapping("save")
    @ResponseBody
    public String save(String username,String password){
        userService.insert(username,password);
        return "Save seccess";
    }

    @RequestMapping("/find")
    @ResponseBody
    public User find(String username){
        System.out.println(username);
        User user = userService.find(username);
        System.out.println(user);
        return user;
    }
}
