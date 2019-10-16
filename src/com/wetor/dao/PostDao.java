package com.wetor.dao;

import com.wetor.entity.Post;

import java.util.List;

/**
 * @author wetor
 */
public interface PostDao {
    /**
     * 发帖
     * @param post post
     */
    public void posting(Post post) throws Exception;
    /**
     * 编辑
     * @param post post
     */
    public void editing(Post post) throws Exception;

    /**
     * 删除
     * @param id id
     */
    public void delete(Integer id) throws Exception;
    /**
     * 获取全部帖子
     * @return List<Post>
     */
    public List<Post> getAll() throws Exception;
    /**
     * 获取指定id帖子
     * @param id id
     * @return Post
     */
    public Post get(Integer id) throws Exception;
    /**
     * 获取全部帖子的ID列表
     * @return List<Integer>
     */
    public List<Integer> getList() throws Exception;

}