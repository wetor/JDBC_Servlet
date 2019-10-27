package com.wetor.servlet;

import com.wetor.entity.Post;
import com.wetor.service.PostService;
import com.wetor.service.PostServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

public class AdminServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PostService post_service=new PostServiceImpl();

        String operation = request.getParameter("operation");
        String str_id=request.getParameter("id");
        Integer id=null;
        String result;
        if(str_id!=null)
            id=Integer.parseInt(str_id);

        if(operation!=null ){

            if(operation.equals("delete")){
                //id=?
                if(id!=null && post_service.delete(id)){
                    result="删除成功！";
                }else{
                    result="删除失败！";
                }
                request.getRequestDispatcher("message?url=admin&result="+result).forward(request, response);
            }
            else if(operation.equals("posting")){
                Post post=new Post();
                post.setId(id);
                post.setTitle(request.getParameter("title"));
                post.setAuthor(request.getParameter("author"));
                String dateStr = request.getParameter("date");
                if(dateStr!=null)
                    post.setDate(new Date(Long.parseLong(dateStr)));
                post.setContent(request.getParameter("content"));


                    //       posting
                    //title=?
                    //author=?
                    //date=?
                    //content=?
                    post.setId(null);
                    if (post_service.posting(post)) {
                        request.setAttribute("result", "发帖成功！");
                    } else {
                        request.setAttribute("result", "发帖失败！");
                    }

            }
        }

        List<Post> list=post_service.getAll();
        request.setAttribute("list",list);
        request.getRequestDispatcher("/admin.jsp").forward(request,response);
        //response.sendRedirect("admin.jsp");
    }
}
