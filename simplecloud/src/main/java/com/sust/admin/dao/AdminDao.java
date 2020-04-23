package com.isscollege.admin.dao;

import com.isscollege.entitys.Admin;
import com.isscollege.entitys.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminDao {

    @Select("select * from cloudusers where username = #{username} and password=#{password}")
    public Admin login(Admin admin);
}
