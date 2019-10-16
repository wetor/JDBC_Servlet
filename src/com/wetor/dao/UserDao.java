package com.wetor.dao;

import com.wetor.entity.User;

/**
 * @author wetor
 */
public interface UserDao {
    public boolean register(User user) throws Exception;
    public boolean login(User user) throws Exception;
}