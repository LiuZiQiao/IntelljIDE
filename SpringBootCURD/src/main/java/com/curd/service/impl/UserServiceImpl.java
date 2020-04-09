package com.curd.service.impl;

import com.curd.dao.IUserDao;
import com.curd.entitys.User;
import com.curd.service.IUserService;
import com.curd.utils.AutoGenerateUserid;
import com.curd.utils.MD5;
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

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public int removeUserByUserid(int userid) {
        return userDao.removeUserByUserid(userid);
    }

    @Override
    public int modifyUser_passByUserid(User user) {
        String md5_pass = new MD5().getMD5ofStr(user.getPassword());
        user.setPassword(md5_pass);
        return userDao.modifyUser_passByUserid(user);
    }
}
