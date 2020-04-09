package com;

import com.bean.User;

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

        User stu = new User();
        stu.setUsername(username);
        stu.setPassword(password);
        request.setAttribute("student", stu);
		System.out.println(stu.getUsername()+"-"+stu.getPassword());



        request.setCharacterEncoding("utf-8");
        PrintWriter pw = response.getWriter();
//		pw.write("Second Servlet");
//		pw.write("<br/>");
//		pw.write("学号："+sno+"<br/>");
//		pw.write("姓名："+sname);
        pw.write(stu.getUsername());
        pw.close();
    }
}
