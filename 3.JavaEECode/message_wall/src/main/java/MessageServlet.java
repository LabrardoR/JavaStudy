import com.fasterxml.jackson.databind.ObjectMapper;
//import com.mysql.jdbc.Connection;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class Message{
    public String from;
    public String to;
    public String message;

    @Override
    public String toString() {
        return "Message{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
@WebServlet("/message")
public class MessageServlet extends HttpServlet {
    //private List<Message> messageList = new ArrayList<>();
    private ObjectMapper objectMapper = new ObjectMapper();

    private DataSource dataSource = new MysqlDataSource();

    // 1.创建数据源
    @Override
    public void init() throws ServletException {
        ((MysqlDataSource) dataSource).setURL("jdbc:mysql://127.0.0.1:3306/message_wall?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("932384");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 读取前端发来的数据，把这个数据保存到服务器这里
        Message message = objectMapper.readValue(req.getInputStream(),Message.class);
        System.out.println("请求中收到的message:" + message);
        // 最简单的办法，直接在内存中保存，使用一个集合类将所有收到的 message全部保存到内存中
        //messageList.add(message);
        //但放到数据库中更科学）
        //返回一个响应
        // 插入数据库
        try {
            save(message);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        resp.setStatus(200);
        resp.getWriter().write("ok");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通过这个方法处理当前获取消息列表的 get 请求，不需要解析请求，直接返回数据即可
        resp.setStatus(200);
        resp.setContentType("application/json; charset=utf8");
        //将 List 类型的数据转化成 json 数组
        // 从数据库查询
        List<Message> messageList = null;
        try {
            messageList = load();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String respJson = objectMapper.writeValueAsString(messageList);
        resp.getWriter().write(respJson);
    }


    private void save(Message message) throws SQLException {
        // 通过这个方法把 message 插入到数据库中

        // 1.创建数据源 init()
        // 2.建立连接
        Connection connection = (Connection) dataSource.getConnection();

        // 3.构造 SQL
        String sql = "insert into message values(?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,message.from);
        statement.setString(2,message.to);
        statement.setString(3,message.message);

        // 4.执行 SQL
        statement.executeUpdate();

        // 5.回收资源
        statement.close();
        connection.close();

    }
    private List<Message> load() throws SQLException {
        // 通过这个方法从数据库读取数据到 message 中

        // 1.提取数据源 init()

        // 2.建立连接
        Connection connection = dataSource.getConnection();

        // 3.构造SQL
        String sql = "select * from message";
        PreparedStatement statement = connection.prepareStatement(sql);

        // 4.执行sql
        ResultSet resultSet = statement.executeQuery();

        // 5.遍历结果集合
        List<Message> messageList = new ArrayList<>();
        while(resultSet.next()){
            Message message = new Message();
            message.from = resultSet.getString("from");
            message.to = resultSet.getString("to");
            message.message = resultSet.getString("message");
            messageList.add(message);
        }
        // 6.回收资源
        resultSet.close();
        statement.close();
        connection.close();

        // 7.返回messageList
        return messageList;
    }
}
