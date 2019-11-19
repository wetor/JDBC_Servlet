package com.wetor.servlet;

import com.wetor.entity.Post;
import com.wetor.entity.User;
import com.wetor.service.PostService;
import com.wetor.service.PostServiceImpl;
import com.wetor.service.UserService;
import com.wetor.service.UserServiceImpl;

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

        String flag=(String)request.getSession().getAttribute("login");
        if(!(flag!=null && flag.equals("true"))){
            //用户名或密码错误，无法进入admin
            response.sendRedirect("login.html");
            return;
        }


        PostService post_service=new PostServiceImpl();
        String operation = request.getParameter("operation");
        String str_id=request.getParameter("id");
        Integer id=null;
        String result;
        if(str_id!=null)
            id=Integer.parseInt(str_id);

        if(operation!=null && operation.equals("delete")){
            //id=?
            if(id!=null && post_service.delete(id)){
                result="删除成功！";
            }else{
                result="删除失败！";
            }
            request.getRequestDispatcher("message?url=admin&result="+result).forward(request, response);
        }




        List<Post> list=post_service.getAll();
        request.setAttribute("list",list);
        request.getRequestDispatcher("/admin.jsp").forward(request,response);
        //response.sendRedirect("admin.jsp");
    }
}
