package com.lxk.mapper;

import com.lxk.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

//    @Insert("insert user (username,password) values (#{username},#{password})")
//    public void save(@Param("username") String username,  @Param("password") String password);
//
//    @Select("select *from user where username=#{username,jdbcType=VARCHAR}")
//    public User findByUserName(@Param("username") String username);

    public void save(String username,String password);
    public User find(String username);
}
