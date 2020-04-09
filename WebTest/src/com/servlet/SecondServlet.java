package com;

import com.bean.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SecondServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        request.setCharacterEncoding("utf-8");
//        request.getParameter("SecondServlet");
        User stu = (User) request.getAttribute("student");
        System.out.println("seconde servlet"+stu.getUsername()+stu.getPassword());


//		request.getParameter("FirstServlet");
//		String sno = request.getParameter("num");
//		String sname = request.getParameter("name");
//		System.out.println(sno+"-"+sname);
//		System.out.println("secondServlet is used");
        PrintWriter pw = response.getWriter();
//		pw.write("Second Servlet");
//		pw.write("<br/>");
//		pw.write("学号："+sno+"<br/>");
//		pw.write("姓名："+sname);
        pw.write(stu.getUsername());
        pw.close();
    }
}
