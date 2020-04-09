package com.curd.dao;


import com.curd.entitys.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author xiaokun-liu
 * @version 1.0
 * @date 2020/4/8 22:05
 */

@Mapper
public interface IUserDao {

    @Insert("insert into users (userid,username,password,sex) values (#{userid},#{username},#{password},#{sex})")
    public int regist(User user) ;

    @Select("select *from users where username=#{username} and password=#{password}")
    public User login(User user);

    @Select("select *from users")
    public List<User> getAllUsers();

    @Delete("delect from users where userid = #{userid}")
    public int removeUserByUserid(Integer userid);

    @Update("update users set password=#{password} where userid=#{userid}")
    public int modifyUser_passByUserid(User user);
}
