package com.example.zsgc.mapper;

import com.example.zsgc.entity.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RoleMapper {
    @Select("select * from role")
    public List<Role> selectAll();

    @Select("select * from role where roleName like concat('%', #{roleName}, '%')")
    public List<Role> selectByName(String roleName);

    @Select("select * from role where roleId=#{roleId}")
    public Role selectByRoleId(int roleId);

    @Select("select * from role where gender=#{gender}")
    public List<Role> selectByGender(int gender);

    @Select("select * from role where workName like concat('%', #{workName}, '%')")
    public List<Role> selectByWorkName(String workName);

    @Insert("insert into role(roleName, gender, intro, workName) values (#{roleName},#{gender},#{intro},#{workName})")
    public void insertRole(Role role);

    @Update("update role set roleName=#{roleName},gender=#{gender},intro=#{intro},workName=#{workName} where roleId=#{roleId}")
    public void updateRole(Role role);

    @Delete("delete from role where roleId=#{roleId}")
    public void deleteRole(int roleId);
}
