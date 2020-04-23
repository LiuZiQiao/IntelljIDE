package com.isscollege.admin.service.impl;

import com.isscollege.admin.dao.AdminDao;
import com.isscollege.admin.service.AdminService;
import com.isscollege.entitys.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminServiceImpl implements AdminService {

    @Autowired(required = false)
    private AdminDao adminDao;


    @Override
    public Admin login(Admin admin) {
        return adminDao.login(admin);
    }
}
