package com.LibraryManageInfo.www.service;

import com.curd.entitys.User;

import java.util.List;

/**
 * @author xiaokun-liu
 * @version 1.0
 * @date 2020/4/8 21:38
 */
public interface IUserService {

    int regist(User user);

    User login(User user);

    List<User> getAllUsers();

    int removeUserByUserid(int userid);

    int modifyUser_passByUserid(User user);
}