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

public class MainServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PostService post_service=new PostServiceImpl();
        List<Post> list;
        list=post_service.getAll();
        request.setAttribute("list",list);
        request.getRequestDispatcher("/main.jsp").forward(request,response);
        /*
        String id=request.getParameter("id");
        PrintWriter pw= response.getWriter();
        pw.print("<html><body>");
        if(id==null){
            list=post_service.getAll();
            pw.print("<h1>test</h1>");
        }else{
            pw.print("<table border=\"1\">\n" +
                    "<tr>\n" +
                    "<td>ID</td>\n" +
                    "<td>标题</td>\n" +
                    "<td>作者</td>\n" +
                    "<td>时间</td>\n" +
                    "<td>内容</td>\n" +
                    "</tr>\n"
            );


            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            if(id.equals("all")){
                list=post_service.getAll();
                if(list!=null){
                    for(Post post : list){
                        pw.print("<tr>\n");
                        pw.print("<td>"+post.getId().toString()+"</td>\n");
                        pw.print("<td>"+post.getTitle()+"</td>\n");
                        pw.print("<td>"+post.getAuthor()+"</td>\n");

                        String dateString = formatter.format(post.getDate());
                        pw.print("<td>"+dateString+"</td>\n");
                        pw.print("<td>"+post.getContent()+"</td>\n");
                        pw.print("</tr>\n");
                    }
                }
            }else{
                Post post=post_service.get(Integer.parseInt(id));
                if(post!=null){
                    pw.print("<tr>\n");
                    pw.print("<td>"+post.getId().toString()+"</td>\n");
                    pw.print("<td>"+post.getTitle()+"</td>\n");
                    pw.print("<td>"+post.getAuthor()+"</td>\n");
                    String dateString = formatter.format(post.getDate());
                    pw.print("<td>"+dateString+"</td>\n");
                    pw.print("<td>"+post.getContent()+"</td>\n");
                    pw.print("</tr>\n");
                }
            }

            pw.print("</table>");
        }


        pw.print("</body></html>");
        pw.flush();*/

    }

}
