package com.example.zsgc.mapper;

import com.example.zsgc.entity.Collection;
import com.example.zsgc.entity.Sale;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CollectionMapper {
    @Select("select * from collection")
    public List<Collection> selectAll();

    @Select("select * from collection where username like concat('%', #{username}, '%')")
    public List<Collection> selectByUsername(String username);

    @Select("select * from collection where merchandiseId=#{merchandiseId}")
    public List<Collection> selectByMerchandiseId(int merchandiseId);

    @Insert("insert into collection(username, merchandiseId) values (#{username},#{merchandiseId})")
    public void insertCollection(Collection collection);

    @Update("update collection set username=#{username},merchandiseId=#{merchandiseId} where coID=#{coID}")
    public void updateCollection(Collection collection);

    @Delete("delete from collection where coID=#{coID}")
    public void deleteCollection(int coID);
}
