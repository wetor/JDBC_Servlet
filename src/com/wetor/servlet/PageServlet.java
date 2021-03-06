package com.wetor.servlet;

import com.wetor.service.PostService;
import com.wetor.service.PostServiceImpl;
import com.wetor.entity.Post;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



public class PageServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PostService post_service = new PostServiceImpl();
        Integer id=Integer.parseInt(request.getParameter("id"));
        Post post = post_service.get(id);
        request.setAttribute("post", post);
        request.getRequestDispatcher("/page.jsp").forward(request, response);
    }
}