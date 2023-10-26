package com.example.zsgc.controller;

import com.example.zsgc.entity.Comment;
import com.example.zsgc.mapper.CommentMapper;
import com.example.zsgc.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentMapper commentMapper;

    @RequestMapping(value = {"/selectAll"}, method = RequestMethod.GET)
    public List<Comment> selectAll() {
        return commentMapper.selectAll();
    }

    @RequestMapping(value = {"/selectByUsername"}, method = RequestMethod.GET)
    public List<Comment> selectByUsername(String username) {
        return commentMapper.selectByUsername(username);
    }

    @RequestMapping(value = {"/selectByFigureName"}, method = RequestMethod.GET)
    public List<Comment> selectByFigureName(String figureName) {
        return commentMapper.selectByFigureName(figureName);
    }

    @RequestMapping(value = {"/selectByFigureId"}, method = RequestMethod.GET)
    public List<Comment> selectByFigureId(int figureId) {
        return commentMapper.selectByFigureId(figureId);
    }

    @RequestMapping(value = {"/selectByContent"}, method = RequestMethod.GET)
    public List<Comment> selectByContent(String content) {
        return commentMapper.selectByContent(content);
    }

    @RequestMapping(value = {"/selectByUpdateTime"}, method = RequestMethod.GET)
    public List<Comment> selectByUpdateTime(Date beginTime, Date endTime) {
        return commentMapper.selectByUpdateTime(beginTime, endTime);
    }

    @RequestMapping(value = {"/insert"}, method = RequestMethod.POST)
    public void insertComment(Comment comment, HttpServletRequest request) {
        String token = request.getHeader("token");
        String username = TokenUtil.getUsername(token);
        comment.setUsername(username);
        comment.setUpdateTime(new Date());
        commentMapper.insertComment(comment);
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.PUT)
    public void updateComment(Comment comment, HttpServletRequest request) {
        String token = request.getHeader("token");
        String username = TokenUtil.getUsername(token);
        comment.setUsername(username);
        comment.setUpdateTime(new Date());
        commentMapper.updateComment(comment);
    }

    @RequestMapping(value = {"/delete"}, method = RequestMethod.DELETE)
    public void deleteComment(int commentId) {
        commentMapper.deleteComment(commentId);
    }
}
