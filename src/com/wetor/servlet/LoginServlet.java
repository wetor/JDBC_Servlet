package com.wetor.servlet;

import com.wetor.entity.User;
import com.wetor.service.UserService;
import com.wetor.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
public class LoginServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter pw= response.getWriter();
        pw.print("<html><body>");
        User user=new User();
        UserService user_service=new UserServiceImpl();

        user.setName(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        if(user_service.login(user)){
            pw.print("<h1>登录成功！</h1>");
        }else{
            pw.print("<h1>登录失败！</h1>");
        }
        pw.print("</body></html>");
        pw.flush();

    }

}
