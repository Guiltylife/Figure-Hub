package com.example.zsgc.mapper;

import com.example.zsgc.entity.RoleImg;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RoleImgMapper {
    @Select("select * from roleimg")
    public List<RoleImg> selectAll();

    @Select("select * from roleimg where roleId=#{roleId}")
    public List<RoleImg> selectByRoleId(int roleId);

    @Insert("insert into roleimg(roleId, imgpath) values (#{roleId},#{imgpath})")
    public void insertRoleImg(RoleImg roleImg);

    @Update("update roleimg set roleId=#{roleId},imgpath=#{imgpath} where roleImgId=#{roleImgId}")
    public void updateRoleImg(RoleImg roleImg);

    @Delete("delete from roleimg where roleImgId=#{roleImgId}")
    public void deleteRoleImg(int roleImgId);
}
