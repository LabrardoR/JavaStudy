package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
// dao:Data Access Object 数据访问对象->用于将数据库访问逻辑从业务逻辑中分离出来
// 通过 BlogDao 来完成针对 blog 表的操作

public class BlogDao {
    // 1. 新增操作（提交博客就会用到）
    public void insert(Blog blog) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            // 1. 建立连接
            connection = DBUtil.getConnection();
            // 2. 构造 SQL
            String sql = "insert into blog values(null,?,?,now(),?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, blog.getTitle());
            statement.setString(2, blog.getContent());
            statement.setInt(3,blog.getBlogId());
            // 3. 执行 SQL
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBUtil.close(connection, statement, null);
        }

    }


    // 2. 查询博客列表（博客列表页）
    public List<Blog> getBlogs(){
        List<Blog> blogList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try{
            connection = DBUtil.getConnection();
            String sql = "select * from blog order by postTime desc";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while(resultSet.next()){
                Blog blog = new Blog();
                blog.setBlogId(resultSet.getInt("blogId"));
                blog.setTitle((resultSet.getString("title")));
                //blog.setContent(resultSet.getString("content"));// 内容太多，博客列表页应该进行截断
                String content = resultSet.getString("content");
                if(content.length() > 100){
                    content = content.substring(0,100) + "...";
                }
                blog.setContent(content);
                blog.setPostTime(resultSet.getTimestamp("postTime"));
                blog.setUserId(resultSet.getInt("userId"));
                blogList.add(blog);
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return blogList;
    }

    // 3. 根据博客 id 查询指定的博客
    public Blog getBlog(int blogId){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try{
            connection = DBUtil.getConnection();
            if(connection!=null){
                System.out.println("数据库连接成功");
            }
            String sql = "select * from blog where blogId = ?";
            statement = connection.prepareStatement(sql);
            if(statement != null){

            }
            statement.setInt(1,blogId);
            resultSet = statement.executeQuery();
            if(resultSet != null){
                System.out.println("博客内容查询成功");
            }
            //由于此处是拿着 blogId 进行查询, blogId 作为主键是唯一的
            if(resultSet.next()){
                Blog blog = new Blog();
                blog.setBlogId(resultSet.getInt("blogId"));
                blog.setTitle((resultSet.getString("title")));
                blog.setContent(resultSet.getString("content"));
                blog.setPostTime(resultSet.getTimestamp("postTime"));
                blog.setUserId(resultSet.getInt("userId"));
                System.out.println("blog: " + blog);
                return blog;
            }
        }catch(SQLException e){
            throw new RuntimeException();
        }finally{
            System.out.println("查询完毕,关闭连接");
            DBUtil.close(connection,statement,resultSet);
        }
        return null;
    }
    // 4. 根据博客 id 删除博客
    public void delete(int blogId){
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = DBUtil.getConnection();
            String sql = "delete from blog where blogId = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,blogId);
            // 3. 执行sql
            statement.executeUpdate();
        }catch(SQLException e) {
            throw new RuntimeException();
        }finally {
            DBUtil.close(connection,statement,null);
        }
    }

}
