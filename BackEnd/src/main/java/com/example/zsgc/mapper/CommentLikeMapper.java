package com.example.zsgc.mapper;

import com.example.zsgc.entity.CommentLike;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommentLikeMapper {
    @Select("select * from commentlike")
    public List<CommentLike> selectAll();

    @Select("select * from commentlike where username like concat('%', #{username}, '%')")
    public List<CommentLike> selectByName(String username);

    @Select("select * from commentlike where commentId=#{commentId}")
    public List<CommentLike> selectByCommentId(int commentId);

    @Insert("insert into commentlike(username, commentId) values (#{username},#{commentId})")
    public void insertCommentLike(CommentLike commentlike);

    @Delete("delete from commentlike where likeId=#{likeId}")
    public void deleteCommentLike(int likeId);
}
