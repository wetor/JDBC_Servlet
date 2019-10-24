package com.wetor.dao;

import com.wetor.entity.User;
import util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImpl extends util.JdbcBase implements UserDao {
    @Override
    public boolean register(User user) throws Exception{
        Integer t_id = user.getId();
        if (t_id == null || t_id < 0) {
            t_id = this.count("t_user");
        }
        this.query("insert into t_user values(?,?,?)",t_id,user.getName(),user.getPassword());
        return true;
    }

    @Override
    public boolean login(User user)  throws Exception{
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        conn = JdbcUtil.getConnection();
        ps = conn.prepareStatement("select * from t_user where u_name=? and u_password=?");
        ps.setString(1, user.getName());
        ps.setString(2, user.getPassword());
        rs = ps.executeQuery();
        if (rs.next()) {
            JdbcUtil.close(rs,ps,conn);
            return true;
        }else{
            JdbcUtil.close(rs,ps,conn);
            return false;
        }


    }
}
