package model;

//import com.mysql.jdbc.Connection;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// 通过这个类，封装数据库建立连接的操作
// 由于接下来代码中，有多给 Servlet 都需要使用数据库，就需要有一个单独的地方来把 DataSource进行封装
// 而不能只是放到某个 Servlet 的 init 中了
// 此处使用单例模式来表示 dataSource
public class DBUtil {

    private volatile static DataSource dataSource = null;
    private static DataSource getDataSource(){
        synchronized (DBUtil.class){
            if (dataSource == null){
                dataSource = new MysqlDataSource();
                ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/blog_system?characterEncoding=utf8&useSSL=false");
                ((MysqlDataSource) dataSource).setUser("root");
                ((MysqlDataSource) dataSource).setPassword("932384");
            }
        }
        return dataSource;
    }

    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }

    public static void close(Connection connection, PreparedStatement statement, ResultSet resultSet) {
        if (resultSet !=null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
