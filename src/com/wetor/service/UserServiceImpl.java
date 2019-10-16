package com.wetor.service;

import com.wetor.dao.UserDao;
import com.wetor.dao.UserDaoImpl;
import com.wetor.entity.User;
import util.TransactionManager;

public class UserServiceImpl implements UserService{
    UserDao user_dao=new UserDaoImpl();
    @Override
    public boolean login(User user) {
        if(user.getName().equals("")||user.getPassword().equals(""))
            return false;
        try{
            TransactionManager.begin();
            user_dao.login(user);
            TransactionManager.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            TransactionManager.rollback();
            return false;
        }
    }

    @Override
    public boolean register(User user) {
        if(user.getName().equals("")||user.getPassword().equals(""))
            return false;
        try{
            TransactionManager.begin();
            user_dao.register(user);
            TransactionManager.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            TransactionManager.rollback();
            return false;
        }
    }
}
