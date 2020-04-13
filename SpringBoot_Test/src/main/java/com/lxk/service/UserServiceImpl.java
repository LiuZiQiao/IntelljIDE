package com.lxk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void register(String username, String password) {
        String sql = "insert into user (userName,password) value(?,?)";
        jdbcTemplate.update(sql,username,password);
    }
}
