package com.wetor.servlet;

import com.wetor.entity.User;
import com.wetor.service.UserService;
import com.wetor.service.UserServiceImpl;
import org.omg.PortableInterceptor.RequestInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
public class LoginServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        User user=new User();
        UserService user_service=new UserServiceImpl();

        user.setName(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        if(user_service.login(user)){
            request.getSession().setAttribute("login","true");
            request.getRequestDispatcher("message?url=admin&result=登录成功！").forward(request, response);

        }else{
            request.getRequestDispatcher("message?url=login.html&result=登录失败！账号或密码错误！").forward(request, response);
        }

    }

}
