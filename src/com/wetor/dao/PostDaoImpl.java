package com.wetor.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.wetor.entity.Post;
import util.JdbcUtil;
/**
 * @author wetor
 */
public class PostDaoImpl extends util.JdbcBase implements PostDao{

    /**
     * 发帖
     *
     * @param post post
     */
    @Override
    public void posting(Post post) throws Exception{
        Integer t_id = post.getId();
        if (t_id == null || t_id < 0) {
            t_id = this.count("t_post_status");// 统计t_post_status中数据数作为id
        }
        this.query("insert into t_post values(?,?,?,?,?)", t_id, post.getTitle(), post.getAuthor(), post.getDate(),
                post.getContent());
        this.query("insert into t_post_status values(?,?,?,?,?)", t_id, t_id, 0, 0, 0);
    }

    /**
     * 编辑
     *
     * @param post post
     */
    @Override
    public void editing(Post post)  throws Exception{
        this.query("update t_post set p_title=?,p_author=?,p_date=?,p_content=? where p_id=?", post.getTitle(),
                post.getAuthor(), post.getDate(), post.getContent(), post.getId());
    }

    /**
     * 删除
     *
     * @param id id
     */
    @Override
    public void delete(Integer id)  throws Exception{
        this.query("update t_post_status set p_id=null,deleted=1 where p_id=?", id);
        this.query("delete from t_post where p_id=?", id);
    }

    /**
     * 获取全部帖子
     *
     * @return List<Post>
     */
    @Override
    public List<Post> getAll()  throws Exception{
        List<Post> list = new ArrayList<Post>();
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        conn = JdbcUtil.getConnection();
        ps = conn.prepareStatement("select * from t_post order by p_id");
        rs = ps.executeQuery();
        while (rs.next()) {
            Post p = new Post();
            p.setId(rs.getInt("p_id"));
            p.setTitle(rs.getString("p_title"));
            p.setAuthor(rs.getString("p_author"));
            p.setDate(new Date(rs.getTimestamp("p_date").getTime()));
            p.setContent(this.clobToString(rs.getClob("p_content")));
            list.add(p);
        }

        JdbcUtil.close(rs,ps,conn);

        return list;
    }

    /**
     * 获取指定id帖子
     *
     * @param id id
     * @return Post
     */
    @Override
    public Post get(Integer id)  throws Exception{
        Post p = new Post();
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        conn = JdbcUtil.getConnection();
        ps = conn.prepareStatement("select * from t_post where p_id=?");
        ps.setInt(1, id);
        rs = ps.executeQuery();
        if (rs.next()) {
            p.setId(rs.getInt("p_id"));
            p.setTitle(rs.getString("p_title"));
            p.setAuthor(rs.getString("p_author"));
            p.setDate(new Date(rs.getTimestamp("p_date").getTime()));
            p.setContent(this.clobToString(rs.getClob("p_content")));
        }


        JdbcUtil.close(rs,ps,conn);

        return p;
    }

    /**
     * 获取全部帖子的ID列表
     *
     * @return List<Integer>
     */
    @Override
    public List<Integer> getList()  throws Exception{
        List<Integer> list = new ArrayList<Integer>();
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        conn = JdbcUtil.getConnection();
        ps = conn.prepareStatement("select p_id from t_post_status where p_id is not null");
        rs = ps.executeQuery();
        while (rs.next()) {
            list.add(rs.getInt(1));
        }

        JdbcUtil.close(rs,ps,conn);


        return list;
    }


}
