package com.example.zsgc.mapper;

import com.example.zsgc.entity.FigureImg;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FigureImgMapper {
    @Select("select * from figureimg")
    public List<FigureImg> selectAll();

    @Select("select * from figureimg where figureId=#{figureId}")
    public List<FigureImg> selectByFigureId(int figureId);

    @Insert("insert into figureimg(figureId, imgpath) values (#{figureId},#{imgpath})")
    public void insertFigureImg(FigureImg figureImg);

    @Update("update figureimg set figureId=#{figureId},imgpath=#{imgpath} where figureImgId=#{figureImgId}")
    public void updateFigureImg(FigureImg figureImg);

    @Delete("delete from figureimg where figureImgId=#{figureImgId}")
    public void deleteFigureImg(int figureImgId);
}
