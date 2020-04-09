package com.curd.controller;

import com.curd.entitys.User;
import com.curd.service.impl.UserServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author xiaokun-liu
 * @version 1.0
 * @date 2020/4/8 21:20
 */

@Controller
@RequestMapping("user")
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

    @RequestMapping(value = "")
    public String index2(){
        return "login";
    }

    @RequestMapping(value = "/index")
    public String index(){
        return "login";
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
            List<User> userList = userService.getAllUsers();
            PageHelper.startPage(1,3);
            PageInfo<User> pageInfo = new PageInfo<>(userList);
            if (userList.size()>0){
                request.setAttribute("userList",userList);
                request.setAttribute("pageInfo",pageInfo);
                return "showAllUsers";
            }
        }
        request.setAttribute("login_error","登录失败，请重新登录");
        return "login";
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "login";
    }

    @RequestMapping(value = "/removeUserByUserid/(userid)")
    public String removeUserByUserid(Integer pageNum, Integer maxPage, @PathVariable Integer userid, HttpServletRequest request){

        if (pageNum <= 1) {
            pageNum = 1;
        } else if (pageNum >= maxPage) {
            pageNum = maxPage;
        }
        PageHelper.startPage(pageNum, 3);
        userService.removeUserByUserid(userid);
        List<User> userList = userService.getAllUsers();
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        request.setAttribute("pageInfo", pageInfo);
        request.setAttribute("userList", userList);
        return "showAllUsers";
    }

    @RequestMapping(value = "/modifyUser_passByUserid")
    public String modifyUser_passByUserid(Integer pageNum, Integer maxPage, @RequestParam("userid") String userid,
                                          @RequestParam("newPass") String newPass, HttpServletRequest req) {
        if (pageNum <= 1) {
            pageNum = 1;
        } else if (pageNum >= maxPage) {
            pageNum = maxPage;
        }
        User user = new User();
        user.setUserid(Integer.parseInt(userid));
        user.setPassword(newPass);
        userService.modifyUser_passByUserid(user);
        PageHelper.startPage(pageNum, 3);
        List<User> userList = userService.getAllUsers();
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        req.setAttribute("pageInfo", pageInfo);
        req.setAttribute("userList", userList);
        return "showAllUsers";
    }

    @RequestMapping(value = "/getAllUsers")
    public String getAllUsers(Integer pageNum, Integer maxPage, HttpServletRequest req) {
        if (pageNum <= 1) {
            pageNum = 1; // 分页的逻辑判断 ,如果当前页小于1就显示第一页
        } else if (pageNum >= maxPage) {
            pageNum = maxPage;// 如果当前页大于最大页就显示最大页
        }
        PageHelper.startPage(pageNum, 3);
        List<User> userList = userService.getAllUsers();
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        req.setAttribute("pageInfo", pageInfo);
        req.setAttribute("userList", userList);
        return "showAllUsers";
    }
}
