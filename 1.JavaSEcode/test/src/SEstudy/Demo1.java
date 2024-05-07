package SEstudy;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Demo1 {
        public static void main(String[] args) throws SQLException {
            //MysqlDataSource mysqlDataSource = new MysqlDataSource();
            //mysqlDataSource.setUrl();
            //此种写法降低了mysql和程序的耦合度
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入学号：");
            int  id = scanner.nextInt();
            System.out.println("请输入姓名:");
            String name = scanner.next();


            // 1. 先创建DataSource
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/java?characterEncoding=utf8&useSSL=false");
            dataSource.setUser("root");
            dataSource.setPassword("932384");

            // 2. 建立和数据库服务器之间的连接，连接好了之后，才能进行后续的 请求-响应 交互
            Connection connection = dataSource.getConnection();

            // 3. 构造 sql
            String sql = "insert into student values(?,?)";//使用问号作为占位符
            //String sql2 = "delete from student where id = 1";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            statement.setString(2,name);

            // 4. 把sql发给服务器
            int n = statement.executeUpdate();
            System.out.println(n);
            // 5. 关闭连接，释放资源
            //后获取到的资源先释放
            statement.close();
            connection.close();

        }


}
