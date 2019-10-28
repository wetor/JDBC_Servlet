package com.wetor.servlet;

import com.wetor.entity.Post;
import com.wetor.service.PostService;
import com.wetor.service.PostServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
public class EditServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        String token=request.getParameter("token");

        String operation = request.getParameter("operation");
        PostService post_service = new PostServiceImpl();
        Integer id=Integer.parseInt(request.getParameter("id"));
        String result;
        Post post;
        if(operation!=null && operation.equals("edit")){
            post=new Post();
            post.setId(id);
            post.setTitle(request.getParameter("title"));
            post.setAuthor(request.getParameter("author"));
            String dateStr = request.getParameter("date");
            if(dateStr!=null)
                post.setDate(new Date(Long.parseLong(dateStr)));
            post.setContent(request.getParameter("content"));

            if(post_service.editing(post)){
                result="修改成功！";
            }else{
                result="修改失败！";
            }
            request.getRequestDispatcher("message?url=admin&result="+result+"&token="+token).forward(request, response);

        }else{
            post= post_service.get(id);
            request.setAttribute("token", token);
            request.setAttribute("post", post);
            request.getRequestDispatcher("/edit.jsp").forward(request, response);
        }


    }
}