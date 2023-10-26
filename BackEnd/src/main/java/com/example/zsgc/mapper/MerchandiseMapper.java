package com.example.zsgc.mapper;

import com.example.zsgc.entity.Manufacturer;
import com.example.zsgc.entity.Merchandise;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MerchandiseMapper {
    @Select("select * from merchandise")
    public List<Merchandise> selectAll();

    @Select("select * from merchandise where merchandiseId=#{merchandiseId}")
    public Merchandise selectByMerchandiseId(int merchandiseId);

    @Select("select * from merchandise where username=#{username}")
    public List<Merchandise> selectByUsername(String username);

    @Select("select * from merchandise where status=${status}")
    public List<Merchandise> selectByStatus(int status);

    @Select("select * from merchandise where type=${type}")
    public List<Merchandise> selectByType(int type);

    @Insert("insert into merchandise(price, updateTime, status, type, username) values (#{price},#{updateTime},#{status},#{type},#{username})")
    public void insertMerchandise(Merchandise merchandise);

    @Update("update merchandise set price=#{price},updateTime=#{updateTime},status=#{status},type=#{type},username=#{username} where merchandiseId=#{merchandiseId}")
    public void updateMerchandise(Merchandise merchandise);

    @Update("update merchandise set status=1 where merchandiseId=#{merchandiseId}")
    public void updateSoldOut(int merchandiseId);

    @Delete("delete from merchandise where merchandiseId=#{merchandiseId}")
    public void deleteMerchandise(int merchandiseId);
}
