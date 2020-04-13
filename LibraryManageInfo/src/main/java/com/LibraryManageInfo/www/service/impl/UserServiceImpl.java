package com.LibraryManageInfo.www.service.impl;

import com.LibraryManageInfo.www.dao.IUserDao;
import com.LibraryManageInfo.www.entitys.User;
import com.LibraryManageInfo.www.service.IUserService;
import com.LibraryManageInfo.www.utils.AutoGenerateUserid;
import com.LibraryManageInfo.www.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xiaokun-liu
 * @version 1.0
 * @date 2020/4/8 21:37
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public int regist(User user) {
        // 解密据说需要60年
        //bug：验证数据库中不存在时注册，避免重复注册
        String md5_pass = new MD5().getMD5ofStr(user.getPassword());
        user.setUserid(new AutoGenerateUserid().getUserid_auto());
        user.setPassword(md5_pass);
        return userDao.regist(user);
    }

    @Override
    public User login(User user) {
        String md5_pass = new MD5().getMD5ofStr(user.getPassword());
        user.setPassword(md5_pass);
        return userDao.login(user);
    }
}
