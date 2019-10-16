package util;


import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Li
 */
public class JdbcUtil {
    private static String driver; // 驱动
    private static String url; // 连接字符串
    private static String user; // 用户名
    private static String password ; // 密码
    static{
        Properties properties = new Properties();
        try (InputStream is = JdbcUtil.class.getResourceAsStream("/util/oracle.properties")) {
            properties.load(is);
            url = properties.getProperty("url");
            user = properties.getProperty("username");
            password = properties.getProperty("password");
            driver = properties.getProperty("driver");
            Class.forName(driver);
        } catch (Exception e) {
            e.getMessage();
        }
    }
    public static Connection getConnection() throws Exception{

        return DriverManager.getConnection(url, user, password);
    }
    public static void close(ResultSet resultSet, PreparedStatement preparedStatement,
                             Connection connection){

        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if(preparedStatement != null ){
                preparedStatement.close();
            }
            if(connection != null ){
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

}