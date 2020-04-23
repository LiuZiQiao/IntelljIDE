package com.isscollege.admin.service;

import com.isscollege.entitys.Admin;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {
    Admin login(Admin admin);
}
