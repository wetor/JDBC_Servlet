package util;

import java.sql.Connection;
import java.sql.SQLException;

/*
 *  事务管理器 用于控制事务
 */
public class TransactionManager {

	public static void begin(){
		try {
			Connection conn = JdbcUtil.getConnection();
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void commit(){
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil.close(null,null,conn);
		}
		
		
	}
	public static void rollback(){
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			conn.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil.close(null,null,conn);
		}
		
	}
	
}
