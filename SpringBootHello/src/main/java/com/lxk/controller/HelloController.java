package com.lxk.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("hello")
    @ResponseBody
    public String Hello(){
        return "hello";
    }

    @RequestMapping("img")
    public String Img(){
        return "static/imgs/1.jpg";
    }
}
