package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// 通过 UserDao 完成针对 user 表的操作
public class UserDao {
    // 新增暂时不需要，不需要实现“注册”功能
    // 删除暂时不需要，不需要实现“注销账户”功能

    // 1. 根据 userId 来查询对应的用户信息(获取用户信息)
    public User getUserById(int userId){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try{
            connection = DBUtil.getConnection();
            String sql = "select * from user where userId=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,userId);
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                User user = new User();
                user.setUserId(resultSet.getInt("userId"));
                user.setUserName(resultSet.getString("username"));
                user.setPassWord(resultSet.getString("password"));
                return user;
            }
        }catch(SQLException e){
            throw new RuntimeException();
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }

        return null;
    }

    // 2. 根据 username 来查到对应的用户信息(登录)
    public User GetUserByName(String username){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            connection = DBUtil.getConnection();
            String sql = "select * from user where username=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1,username);
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                User user = new User();
                user.setUserName(resultSet.getString("username"));
                user.setUserId(resultSet.getInt("userId"));
                user.setPassWord(resultSet.getString("password"));
                return user;
            }

        }catch (SQLException e){
            throw new RuntimeException();
        }finally {
            DBUtil.close(connection, statement, resultSet);
        }

        return null;
    }

}
