/*
* JDBC基本操作类
* */
package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.*;

public class JdbcBase {
    public void query(String sql, Object... objs) throws Exception{
        PreparedStatement ps = null;
        Connection conn = null;
        conn = JdbcUtil.getConnection();
        ps = conn.prepareStatement(sql);
        // 循环为每一个变量设置参数
        for (int i = 0; i < objs.length; i++) {
            if (objs[i].getClass().isAssignableFrom(java.util.Date.class)) {
                // java.util.Date -> java.sql.Date
                ps.setTimestamp(i + 1, new java.sql.Timestamp(((java.util.Date) objs[i]).getTime()));
            } else {
                ps.setObject(i + 1, objs[i]);
            }
        }
        ps.execute();
        JdbcUtil.close(null,ps,conn);

    }
    protected int count(String table) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        int count = -1;
        try {
            conn = JdbcUtil.getConnection();
            ps = conn.prepareStatement("select count(*) as result from "+table);
            rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.close(rs,ps,conn);
        }
        return count;
    }
    /**
     * Clob类型 转String  https://www.cnblogs.com/city-light/p/8663677.html
     *
     * @param clob clob
     */
    protected String clobToString(Clob clob) throws SQLException, IOException {
        String reString = "";
        Reader is = clob.getCharacterStream();
        BufferedReader br = new BufferedReader(is);
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        while (s != null) {
            sb.append(s);
            s = br.readLine();
        }
        reString = sb.toString();
        br.close();
        is.close();
        return reString;
    }

}
