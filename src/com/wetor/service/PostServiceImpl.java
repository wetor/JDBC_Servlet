package com.wetor.service;

import com.wetor.dao.PostDao;
import com.wetor.dao.PostDaoImpl;
import com.wetor.entity.Post;
import util.TransactionManager;

import java.util.Date;
import java.util.List;

public class PostServiceImpl implements PostService{

    PostDao post_dao=new PostDaoImpl();
    @Override
    public boolean posting(Post post) {
        if(post.getTitle().equals(""))
            post.setTitle("新文章");
        if(post.getAuthor().equals(""))
            post.setAuthor("无名");
        if(post.getDate() == null)
            post.setDate(new Date());
        try{
            TransactionManager.begin();
            post_dao.posting(post);
            TransactionManager.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            TransactionManager.rollback();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Post get(Integer id) {
        try{
            TransactionManager.begin();
            Post retn = post_dao.get(id);
            TransactionManager.commit();
            return retn;
        }catch (Exception e){
            e.printStackTrace();
            TransactionManager.rollback();
            return null;
        }
    }

    @Override
    public List<Post> getAll() {
        try{
            TransactionManager.begin();
            List<Post> retn = post_dao.getAll();
            TransactionManager.commit();
            return retn;
        }catch (Exception e){
            e.printStackTrace();
            TransactionManager.rollback();
            return null;
        }
    }
}