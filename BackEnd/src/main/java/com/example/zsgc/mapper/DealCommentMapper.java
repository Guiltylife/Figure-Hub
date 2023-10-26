package com.example.zsgc.mapper;

import com.example.zsgc.entity.DealComment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DealCommentMapper {
    @Select("select * from dealcomment")
    public List<DealComment> selectAll();

    @Select("select * from dealcomment where buyer like concat('%', #{buyer}, '%')")
    public List<DealComment> selectByBuyer(String buyer);

    @Select("select * from dealcomment where dealId=#{dealId}")
    public List<DealComment> selectByDealId(int dealId);

    @Insert("insert into dealcomment(buyer, dealId, updateTime, content) values (#{buyer},#{dealId},#{updateTime},#{content})")
    public void insertDealComment(DealComment dealComment);

    @Update("update dealcomment set buyer=#{buyer},dealId=#{dealId},updateTime=#{updateTime},content=#{content} where dealCommentId=#{dealCommentId}")
    public void updateDealComment(DealComment dealComment);

    @Delete("delete from dealcomment where dealCommentId=#{dealCommentId}")
    public void deleteDealComment(int dealCommentId);
}
