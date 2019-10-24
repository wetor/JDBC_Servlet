package com.wetor.service;

import com.wetor.entity.Post;

import java.util.List;

public interface  PostService {
    public boolean posting(Post post);
    public boolean delete(int id);
    public Post get(Integer id);
    public List<Post> getAll();

}
