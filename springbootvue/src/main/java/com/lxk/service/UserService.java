package com.lxk.service;
import com.lxk.model.User;

public interface UserService {
    public boolean Register(String username,String password);
    public User Login(String username);
}
