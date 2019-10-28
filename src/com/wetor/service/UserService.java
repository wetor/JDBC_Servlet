package com.wetor.service;

import com.wetor.entity.User;

public interface UserService {
    public boolean login(User user);
    public boolean register(User user);
    public String getUserToken(User user);
    public User getTokenUser(String token);
}
