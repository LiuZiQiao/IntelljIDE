package com.dao;

import com.bean.User;
import com.bean.jdbcUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDao {
    public User Login(String username,String password){
        User user = new User();
        Connection conn = null;
        String sql = "select *from users";
        conn = jdbcUtil.getConnection();
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()){
                System.out.println(resultSet.getString("username")+resultSet.getString("password"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
