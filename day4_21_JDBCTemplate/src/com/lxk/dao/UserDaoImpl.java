package com.lxk.dao;

import com.lxk.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class UserDaoImpl extends JdbcDaoSupport implements UserDao{
    @Override
    public void add(User user) {
        System.out.println("dao 添加"+user);
        getJdbcTemplate().update("inserte into user(username,password) value (?,?)",user.getUserName(),user.getPassword());
    }
}
