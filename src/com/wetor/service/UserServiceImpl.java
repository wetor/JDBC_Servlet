package com.wetor.service;

import com.wetor.dao.UserDao;
import com.wetor.dao.UserDaoImpl;
import com.wetor.entity.User;
import util.EncrypDES;
import util.TransactionManager;

public class UserServiceImpl implements UserService{
    UserDao user_dao=new UserDaoImpl();
    @Override
    public boolean login(User user) {
        if(user.getName().equals("")||user.getPassword().equals(""))
            return false;
        try{
            TransactionManager.begin();
            boolean retn = user_dao.login(user);
            TransactionManager.commit();
            return retn;
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
            boolean retn = user_dao.register(user);
            TransactionManager.commit();
            return retn;
        }catch (Exception e){
            e.printStackTrace();
            TransactionManager.rollback();
            return false;
        }
    }
    @Override
    public String getUserToken(User user){
        String token=null;
        try{
            EncrypDES des = new EncrypDES();// 自定义密钥
            token=user.getName()+"|"+user.getPassword();
            token=des.encrypt(token);
            return token;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public User getTokenUser(String token){
        if(token==null)
            return null;
        User user=new User();
        try{
            EncrypDES des = new EncrypDES();// 自定义密钥
            String[] str=des.decrypt(token).split("\\|");
            if(str.length!=2)
                return null;
            user.setName(str[0]);
            user.setPassword(str[1]);
            return user;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
