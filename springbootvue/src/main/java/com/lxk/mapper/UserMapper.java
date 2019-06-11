package com.lxk.mapper;
import com.lxk.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

//    @Insert("insert user value(#{username},#{password})")
//    public void Register(@Param("username") String username,@Param("password") String password);
    public User Login(String username);
    public void Register(String username,String password);
}
