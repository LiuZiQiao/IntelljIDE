package com.lxk.service;

import com.lxk.model.User;

public interface UserService {
    public void insert(String username, String password);
    public User find(String username);
}
