package com.example.zsgc.mapper;

import com.example.zsgc.entity.Figure;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FigureMapper {
    @Select("select * from figure")
    public List<Figure> selectAll();

    @Select("select * from figure where figureName" +
            " like concat('%', #{figureName}, '%')")
    public List<Figure> selectByName(String figureName);

    @Select("select * from figure where figureId=#{figureId}")
    public Figure selectByFigureId(int figureId);

    @Select("select * from figure where figureType=#{figureType}")
    public List<Figure> selectByType(int figureType);

    @Select("select * from figure where price=#{price}")
    public List<Figure> selectByPrice(double price);

    @Select("select * from figure where prop=#{prop}")
    public List<Figure> selectByProp(String prop);

    @Select("select * from figure where manuName like concat('%', #{manuName}, '%')")
    public List<Figure> selectByManuName(String manuName);

    @Insert("insert into figure(figureName, figureType, price, prop, manuName) " +
            "values (#{figureName},#{figureType},#{price},#{prop},#{manuName})")
    public void insertFigure(Figure figure);

    @Update("update figure set " +
            "figureName=#{figureName},figureType=#{figureType}," +
            "price=#{price},prop=#{prop},manuName=#{manuName} " +
            "where figureId=#{figureId}")
    public void updateFigure(Figure figure);

    @Delete("delete from figure where figureId=#{figureId}")
    public void deleteFigure(int figureId);

}
