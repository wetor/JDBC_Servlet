package com.wetor.servlet;

import com.wetor.entity.Post;
import com.wetor.service.PostService;
import com.wetor.service.PostServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MessageServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setAttribute("token",request.getParameter("token"));
        request.setAttribute("url",request.getParameter("url"));
        request.setAttribute("message",request.getParameter("result"));
        request.getRequestDispatcher("/message.jsp").forward(request,response);

    }

}
