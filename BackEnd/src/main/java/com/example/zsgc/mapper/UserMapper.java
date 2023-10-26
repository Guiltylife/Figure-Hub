package com.example.zsgc.mapper;

import com.example.zsgc.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

//    @Select(value = "select u.username,u.password,u.nickname,u.type,u.token from user u where u.username=#{username}")
//    @Results({@Result(property = "username",column = "username"), @Result(property = "password",column = "password")})
//    User findUserByName(@Param("username") String username);
    @Select(value = "select * from user where username=#{username}")
    User findUserByName(String username);

    @Select("select * from user")
    List<User> selectAll();

    @Insert("insert into user values(#{username},#{password},#{nickname},#{type},#{token},#{imgpath})")
    void register(User user);

    @Select("select u.username from user u where u.username = #{username} and password = #{password}")
    String login(User user);

    @Update("update user set token=#{token} where username=#{username}")
    void updateToken(User user);

    @Update("update user set imgpath=#{imgpath} where username=#{username}")
    void updateImgPath(User user);

}