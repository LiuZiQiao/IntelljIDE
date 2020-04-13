package com.LibraryManageInfo.www.service;


import com.LibraryManageInfo.www.entitys.User;

import java.util.List;

/**
 * @author xiaokun-liu
 * @version 1.0
 * @date 2020/4/8 21:38
 */
public interface IUserService {

    int regist(User user);

    User login(User user);
}