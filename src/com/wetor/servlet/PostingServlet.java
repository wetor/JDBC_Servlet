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
public class PostingServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter pw= response.getWriter();
        pw.print("<html><body>");
        Post post=new Post();
        PostService post_service=new PostServiceImpl();
        post.setTitle(request.getParameter("title"));
        post.setAuthor(request.getParameter("author"));
        post.setContent(request.getParameter("content"));
        if(post_service.posting(post)){
            pw.print("<h1>发帖成功！</h1>");
        }else{
            pw.print("<h1>发帖失败！</h1>");
        }
        pw.print("</body></html>");
        pw.flush();

    }

}
