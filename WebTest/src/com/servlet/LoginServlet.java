package com.servlet;

import com.bean.User;
import com.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = null;
        UserDao userDao = new UserDao();
        user = userDao.Login(username,password);
        if (user != null){
            request.setAttribute("user", user);
            request.setCharacterEncoding("utf-8");
            PrintWriter pw = response.getWriter();
            pw.write(user.getUsername()+"    welcome to website test");
            pw.close();
        }
		System.out.println(user.getUsername()+"-"+user.getPassword());
    }
}
