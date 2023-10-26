package com.example.zsgc.mapper;

import com.example.zsgc.entity.Figure;
import com.example.zsgc.entity.Figurization;
import com.example.zsgc.entity.FigurizationFront;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FigurizationMapper {
    @Select("select distinct figurization.relaId,figurization.figureId,figurization.roleId,figure.figureName,role.roleName from figurization,figure,role where figurization.roleId=role.roleId and figurization.figureId=figure.figureId")
    public List<FigurizationFront> selectAll();

    @Select("select * from figurization where figureId=#{figureId}")
    public List<Figurization> selectByFigureId(int figureId);

    @Select("select * from figurization where roleId=#{roleId}")
    public List<Figurization> selectByRoleId(int roleId);

    @Insert("insert into figurization(figureId, roleId) values (#{figureId},#{roleId})")
    public void insertFigurization(Figurization figurization);

    @Update("update figurization set figureId=#{figureId},roleId=#{roleId} where relaId=#{relaId}")
    public void updateFigurization(Figurization figurization);

    @Delete("delete from figurization where relaId=#{relaId}")
    public void deleteFigurization(int relaId);
}
