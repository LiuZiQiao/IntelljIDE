package com.isscollege.admin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.isscollege.admin.service.impl.AdminServiceImpl;
import com.isscollege.entitys.Admin;
import com.isscollege.entitys.Users;
import com.isscollege.user.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private AdminServiceImpl adminService;


    @RequestMapping(value = "/login")
    public String login(Admin admin, HttpServletRequest req, HttpSession session) {
        System.out.println("123");
        admin.setUsername("bbb");
        admin.setPassword("111");
      //  System.out.println(user1.getUsername());
       // System.out.println(user1.getUserid());
      //  LOG.info("login...   " + user1);
        Admin admin1 = adminService.login(admin);
//		System.out.println(user.getUsername());
//		System.out.println(user.getId());
        // 登录成功&& user.getUserid() > 0 && user.getUserid() > 0
        if (admin != null ) {
            session.setAttribute("admin", admin);
             PageHelper.startPage(1, 3);
              List<Users> userList = userService.getAllUsers();
            // 分页
              PageInfo<Users> pageInfo = new PageInfo<>(userList);
               req.setAttribute("pageInfo", pageInfo);
               req.setAttribute("userList", userList);
            return "showAllUsers";
        }
        req.setAttribute("login_error", "用户名称或密码不正确，请重新输入");
        return "login";
    }

    @RequestMapping(value = "/getAllUsers")
    public String getAllUser(Integer pageNum, Integer maxPage, HttpServletRequest req) {
       // System.out.println("333");
       // System.out.println(pageNum);
       // System.out.println(maxPage);
        if (pageNum <= 1) {
            pageNum = 1;
        } else if (pageNum >= maxPage) {
            pageNum = maxPage;
        }
       // System.out.println(pageNum);
        //System.out.println(maxPage);
        PageHelper.startPage(pageNum, 3);
        //获取所有用户
        List<Users> userList = userService.getAllUsers();
        PageInfo<Users> pageInfo = new PageInfo<>(userList);
        req.setAttribute("pageInfo", pageInfo);
        req.setAttribute("userList", userList);
        return "showAllUsers";
    }
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "login_admin";
    }

    @RequestMapping(value = "/changeState")
    public  String  changeState(Users user,Integer pageNum, Integer maxPage,HttpServletRequest req){
        if(user.getState().equals("启用")){
            user.setState("禁用");
        }else {
            user.setState("启用");
        }
         userService.changeStateById(user);
        if (pageNum <= 1) {
            pageNum = 1;
        } else if (pageNum >= maxPage) {
            pageNum = maxPage;
        }
        PageHelper.startPage(pageNum, 3);
        List<Users> userList = userService.getAllUsers();
        PageInfo<Users> pageInfo = new PageInfo<>(userList);
        req.setAttribute("pageInfo", pageInfo);
        req.setAttribute("userList", userList);
        return "showAllUsers";
    }

}
