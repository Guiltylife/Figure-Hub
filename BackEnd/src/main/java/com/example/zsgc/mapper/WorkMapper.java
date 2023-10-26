package com.example.zsgc.mapper;

import com.example.zsgc.entity.Work;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface WorkMapper {
    @Select("select * from work")
    public List<Work> selectAll();

    @Select("select * from work where workName like concat('%', #{workName}, '%')")
    public List<Work> selectByName(String workName);

    @Select("select * from work where kind=#{kind}")
    public List<Work> selectByKind(int kind);

    @Insert("insert into work(workName, kind, intro) values (#{workName},#{kind},#{intro})")
    public void insertWork(Work work);

    @Update("update work set workName=#{workName},kind=#{kind},intro=#{intro} where workName=#{workName}")
    public void updateWork(Work work);

    @Delete("delete from work where workName=#{workName}")
    public void deleteWork(String workName);
}
