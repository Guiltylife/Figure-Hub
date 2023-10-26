package com.example.zsgc.mapper;

import com.example.zsgc.entity.Manufacturer;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ManufacturerMapper {
    @Select("select * from manufacturer")
    public List<Manufacturer> selectAll();

    @Select("select * from manufacturer where manuName like concat('%', #{manuName}, '%')")
    public List<Manufacturer> selectByName(String manuName);

    @Select("select * from manufacturer where manuLink like concat('%', #{manuLink}, '%')")
    public List<Manufacturer> selectByLink(String manuLink);

    @Insert("insert into manufacturer(manuName, manuLink) values (#{manuName},#{manuLink})")
    public void insertManufacturer(Manufacturer manufacturer);

    @Update("update manufacturer set manuName=#{manuName},manuLink=#{manuLink} where manuName=#{manuName}")
    public void updateManufacturer(Manufacturer manufacturer);

    @Delete("delete from manufacturer where manuName=#{manuName}")
    public void deleteManufacturer(String manuName);
}
