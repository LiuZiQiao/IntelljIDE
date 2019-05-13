package com.lxk.service;

import com.lxk.mapper.UserMapper;
import com.lxk.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public void insert(String username, String password) {
        System.out.println(username+"-"+password);
        userMapper.save(username,password);
    }

    @Override
    public User find(String username) {
        User user = userMapper.find(username);
        return user;
    }
}
