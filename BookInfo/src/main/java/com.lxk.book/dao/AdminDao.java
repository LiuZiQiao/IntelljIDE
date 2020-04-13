package com.lxk.book.dao;

import com.lxk.book.entitys.Admin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author xiaokun-liu
 * @version 1.0
 * @date 2020/4/12 0:45
 */
@Mapper
public interface AdminDao {

    @Insert("insert into admin (adminId,password) values (#{adminId},#{password})")
    public int regist(Admin admin) ;

    @Select("select *from admin where adminId=#{adminId} and password=#{password}")
    public Admin login(Admin admin);


}
