package com.example.zsgc.mapper;

import com.example.zsgc.entity.MerchandiseImg;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MerchandiseImgMapper {
    @Select("select * from merchandiseimg")
    public List<MerchandiseImg> selectAll();

    @Select("select * from merchandiseimg where merchandiseId=#{merchandiseId}")
    public List<MerchandiseImg> selectByMerchandiseId(int merchandiseId);

    @Insert("insert into merchandiseimg(merchandiseId, imgpath) values (#{merchandiseId},#{imgpath})")
    public void insertMerchandiseImg(MerchandiseImg merchandiseImg);

    @Update("update merchandiseimg set merchandiseId=#{merchandiseId},imgpath=#{imgpath} where merchandiseImgId=#{merchandiseImgId}")
    public void updateMerchandiseImg(MerchandiseImg merchandiseImg);

    @Delete("delete from merchandiseimg where merchandiseImgId=#{merchandiseImgId}")
    public void deleteMerchandiseImg(int merchandiseImgId);
}
