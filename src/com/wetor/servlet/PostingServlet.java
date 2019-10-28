package com.wetor.servlet;

import com.wetor.service.PostService;
import com.wetor.service.PostServiceImpl;
import com.wetor.entity.Post;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class PostingServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        String token=request.getParameter("token");

        String operation = request.getParameter("operation");
        PostService post_service = new PostServiceImpl();
        String result;
        Post post;
        if(operation!=null && operation.equals("posting")){
            post=new Post();
            post.setId(null);
            post.setTitle(request.getParameter("title"));
            post.setAuthor(request.getParameter("author"));
            String dateStr = request.getParameter("date");
            if(dateStr!=null)
                post.setDate(new Date(Long.parseLong(dateStr)));
            post.setContent(request.getParameter("content"));

            if (post_service.posting(post)) {
                result="发帖成功！";
            } else {
                result="发帖失败！";
            }
            request.getRequestDispatcher("message?url=admin&result="+result+"&token="+token).forward(request, response);

        }else{
            request.setAttribute("token", token);
            request.getRequestDispatcher("/posting.jsp").forward(request, response);
        }

    }

}
