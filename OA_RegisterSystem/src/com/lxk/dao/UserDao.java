package com.lxk.dao;

import java.util.List;

import com.lxk.domain.User;

public interface UserDao {

	User find(String username, String password);

	List<User> findAll();

	void save(User user);

	User find(String userId);

	void updateUserRole(String userId, String[] roleIds);

}
