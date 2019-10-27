package com.wetor.servlet;

import com.wetor.service.PostService;
import com.wetor.service.PostServiceImpl;
import com.wetor.entity.Post;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.List;

public class BlogServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PostService post_service=new PostServiceImpl();
        List<Post> list=post_service.getAll();
        request.setAttribute("list",list);
        request.getRequestDispatcher("/blog.jsp").forward(request,response);

    }

}
