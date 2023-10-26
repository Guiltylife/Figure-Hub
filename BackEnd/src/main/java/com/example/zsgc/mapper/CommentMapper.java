package com.example.zsgc.mapper;

import com.example.zsgc.entity.Comment;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface CommentMapper {
    @Select("select * from comment")
    public List<Comment> selectAll();

    @Select("select * from comment where username like concat('%', #{username}, '%')")
    public List<Comment> selectByUsername(String username);

    @Select("select commentId,username,figure.figureId,content,updateTime from figure,comment where figureName like concat('%', #{figureName}, '%') and figure.figureId=comment.figureId")
    public List<Comment> selectByFigureName(String figureName);

    @Select("select * from comment where figureId=#{figureId}")
    public List<Comment> selectByFigureId(int figureId);

    @Select("select * from comment where content like concat('%', #{content}, '%')")
    public List<Comment> selectByContent(String content);

    @Select("select * from comment where date_format(updateTime,'%y%m%d') >= date_format(#{beginTime},'%y%m%d') and date_format(updateTime,'%y%m%d') <= date_format(#{endTime},'%y%m%d')")
    public List<Comment> selectByUpdateTime(Date beginTime, Date endTime);

    @Insert("insert into comment(username, figureId, content, updateTime) values (#{username},#{figureId},#{content},#{updateTime})")
    public void insertComment(Comment comment);

    @Update("update comment set content=#{content},updateTime=#{updateTime} where commentId=#{commentId}")
    public void updateComment(Comment comment);

    @Delete("delete from comment where commentId=#{commentId}")
    public void deleteComment(int commentId);
}
