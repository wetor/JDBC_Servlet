package test;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import com.wetor.entity.Post;
import com.wetor.dao.PostDao;
import com.wetor.dao.PostDaoImpl;

import util.JdbcBase;
import util.JdbcUtil;
import org.junit.Test;

public class test {
    @Test
    public void proParties(){

        System.out.println(Test.class.getResource("/"));
        Properties properties = new Properties();
        try (InputStream is = JdbcUtil.class.getResourceAsStream("/Jdbc/oracle.properties")) {
            properties.load(is);
            String url = properties.getProperty("url");
            String user = properties.getProperty("username");
            String password = properties.getProperty("password");
            String driver = properties.getProperty("driver");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void DropTable() {
        JdbcBase test = new JdbcBase();
        try {
            test.query("drop table t_post");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void CreatTable() throws Exception{
        JdbcBase test = new JdbcBase();
        test.query(
                "create table t_post(p_id int primary key,p_title varchar(128) not null,p_author varchar(32)," +
                        "p_date timestamp,p_content clob)");
        //帖子主表
        test.query(
                "create table t_post_status(s_id int primary key,p_id int,deleted int,hidden int,top int, " +
                        "foreign key(p_id) references t_post(p_id) )");
        //存放帖子ID信息
        test.query(
                "create table t_user(u_id int primary key,u_name varchar(32) not null," +
                        "u_password varchar(32) not null )");
        //用户表
    }
    @Test
    public void CreatTable2() throws Exception{
        JdbcBase test = new JdbcBase();
        test.query(
                "create table t_user(u_id int primary key,u_name varchar(32) not null," +
                        "u_password varchar(32) not null )");
        //用户表
    }

    /**
     * 加入测试用户
     */
    @Test
    public void Init()throws Exception{
        JdbcBase test = new JdbcBase();
        test.query("insert into t_user values(0,'wetor','123456')");
    }

    @Test
    public void Dao_posting()throws Exception {
        PostDao post = new PostDaoImpl();
        post.posting(new Post("Title test", "wetor", new Date(), "test contentest contents1test contents1test contents1test contents1test contents1test contents1test contents1test contents1test contents1test contents1ts1\r\ntest contents2\r\ntest contentstest contents1test contents1test contents1test contents1test contents13\r\ntest conttest contents1test contents1test contents1test contents1test contents1test contents1test contents1test contents1ents4\r\ntest contents5\r\ntest contents6\r\ntest contents7\r\ntest contents8\r\ntest contents\r\ntest contents\r\ntest contents\ntest contents\ntest contents\ntest contents\n"));
    }

    @Test
    public void Dao_editing()throws Exception {
        PostDao post = new PostDaoImpl();
        post.editing(new Post(3, "Title testxxx", "wetoraaa", new Date(), "dsdasdtest contents\n"));
    }

    @Test
    public void Dao_delete() throws Exception{
        PostDao post = new PostDaoImpl();
        post.delete(0);
    }
    @Test
    public void Dao_getAll()throws Exception{
        PostDao post = new PostDaoImpl();
        List<Post> p= post.getAll();
        for(int i=0;i<p.size();i++){
            System.out.println(p.get(i).toString());
        }
    }
    @Test
    public void Dao_getList()throws Exception{
        PostDaoImpl post = new PostDaoImpl();
        List<Integer> p= post.getList();
        for(int i=0;i<p.size();i++){
            System.out.println(post.get(p.get(i)).toString());
        }
    }
}
