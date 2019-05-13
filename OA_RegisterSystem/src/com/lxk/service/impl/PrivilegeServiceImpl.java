package com.lxk.service.impl;

import java.util.List;

import com.lxk.dao.FunctionDao;
import com.lxk.dao.RoleDao;
import com.lxk.dao.UserDao;
import com.lxk.dao.impl.FunctionDaoImpl;
import com.lxk.dao.impl.RoleDaoImpl;
import com.lxk.dao.impl.UserDaoImpl;
import com.lxk.domain.Function;
import com.lxk.domain.Role;
import com.lxk.domain.User;
import com.lxk.service.PrivilegeService;

public class PrivilegeServiceImpl implements PrivilegeService {
	private UserDao userDao = new UserDaoImpl();
	private FunctionDao functionDao = new FunctionDaoImpl();
	private RoleDao roleDao = new RoleDaoImpl();
	public User login(String username, String password) {
		return userDao.find(username,password);
	}
	public List<Function> findAllFunctions() {
		return functionDao.findAll();
	}
	public void addFunction(Function function) {
		functionDao.save(function);
	}
	public List<Role> findAllRoles() {
		return roleDao.findAll();
	}
	public void addRole(Role role) {
		roleDao.save(role);
	}
	public Role findRoleById(String roleId) {
		return roleDao.find(roleId);
	}
	public void grantFunction2Role(String roleId, String[] functionIds) {
		roleDao.updateRoleFunction(roleId,functionIds);
	}
	public List<User> findAllUsers() {
		return userDao.findAll();
	}
	public void addUser(User user) {
		userDao.save(user);
	}
	public User findUserById(String userId) {
		return userDao.find(userId);
	}
	public void grantRole2User(String userId, String[] roleIds) {
		userDao.updateUserRole(userId,roleIds);
	}

}
