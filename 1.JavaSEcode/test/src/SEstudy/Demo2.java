package SEstudy;//jdbc 查询

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Demo2 {
    public void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入id");
        int id = scanner.nextInt();
        System.out.println("请输入姓名");
        String name = scanner.next();

        //1. 创建DataSource
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/java?characterEncoding=utf8&useSSL=false");
        dataSource.setUser("root");
        dataSource.setPassword("932384");

        // 2. 建立数据库和服务器之间的连接，建立好了之后才能进行 请求-响应 交互
        Connection connection = dataSource.getConnection();

        // 3. 构造sql
        String sql = "select * from student";
        PreparedStatement statement = connection.prepareStatement(sql);
        //statement.setInt(1,id);
        //statement.setString(2,name);

        // 4. 把sql发给服务器
        ResultSet resultSet = statement.executeQuery();
        //System.out.println("n = " + n);

        // 5. 遍历结果集合
        // 通过next方法就可以获取到临时表中的每一行数据，如果获取到最后一行之后，再执行next返回false，循环结束
        while(resultSet.next()){
            int _id = resultSet.getInt("id");
            String _name = resultSet.getString("name");
            System.out.println("id = " + _id + ", name = " + _name);
        }

        // 6. 清理资源，关闭连接
        resultSet.close();
        statement.close();
        connection.close();






    }
}
