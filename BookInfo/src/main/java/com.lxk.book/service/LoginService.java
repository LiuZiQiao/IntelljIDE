package com.lxk.book.service;


import com.lxk.book.dao.AdminDao;
import com.lxk.book.entitys.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private AdminDao adminDao;

    public int regist(Admin admin) {
        return adminDao.regist(admin);
    }

    public Admin login(Admin admin) {
        return adminDao.login(admin);
    }

    public int repasswd(Admin admin) {
        if (adminDao.getAdmin(admin.getAdminId())){
            if(adminDao.delete(admin.getAdminId())){
                int ret = adminDao.regist(admin);
                return ret;
            }
        }
        return 0;
    }
}
