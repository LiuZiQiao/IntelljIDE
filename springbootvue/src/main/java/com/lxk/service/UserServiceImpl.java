package com.lxk.service;

import com.lxk.mapper.UserMapper;
import com.lxk.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMpaaer;
    @Override
    public boolean Register(String username, String password) {
        userMpaaer.Register(username, password);
        return true;
    }
    @Override
    public User Login(String username) {
       return  userMpaaer.Login(username);
    }
}
