package com.lxk.book.controller;


import com.lxk.book.entitys.Admin;
import com.lxk.book.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.logging.Logger;

//标注为一个Spring mvc的Controller
@Controller
public class LoginController {
    private static final Logger LOG = Logger.getLogger(String.valueOf(LoginController.class));

    @Autowired
    private LoginService loginService;

    @ResponseBody
    @RequestMapping(value = "/hello")
    public String hello(){
        return "hello";
    }



    //负责处理login.html请求
    @RequestMapping(value = {"/"})
    public String toLogin(HttpServletRequest request){
        request.getSession().invalidate();
        return "login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public @ResponseBody Object login(Admin admin, HttpServletRequest request, HttpSession session){
        LOG.info("login..."+admin);
        admin = loginService.login(admin);
        System.out.println(admin);
        HashMap<String, String> res = new HashMap<String, String>();
        if(admin!=null){
            request.getSession().setAttribute("admin",admin);
            res.put("stateCode", "1");
            res.put("msg","登陆成功！");
        }else{
            res.put("stateCode", "0");
            res.put("msg","用户不存在！");
        }
        return res;
    }

    @RequestMapping("/logout.html")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/login.html";
    }


    @RequestMapping(value = "/regist_page")
    public String regist(){
        return "regist";
    }

    @RequestMapping(value = "/regist")
    public String regist(Admin admin, HttpServletRequest request){
        LOG.info("regist----"+admin);
        int num = loginService.regist(admin);
        if (num>0){
            return "login";
        }
        request.setAttribute("regist_error","注册失败，请重新注册");
        return "regist";
    }

    @RequestMapping("/index")
    public ModelAndView toAdminMain(HttpServletResponse response) {
            LOG.info("index"+"111");
            return new ModelAndView("index");
    }



    //配置404页面
     @RequestMapping("*")
     public String notFind(){
     return "404";
       }


}