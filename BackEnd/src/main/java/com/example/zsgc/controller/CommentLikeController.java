package com.example.zsgc.controller;

import com.example.zsgc.entity.CommentLike;
import com.example.zsgc.mapper.CommentLikeMapper;
import com.example.zsgc.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/commentlike")
public class CommentLikeController {
    @Autowired
    private CommentLikeMapper commentLikeMapper;

    @RequestMapping(value = {"/selectAll"}, method = RequestMethod.GET)
    public List<CommentLike> selectAll() {
        return commentLikeMapper.selectAll();
    }

    @RequestMapping(value = {"/selectByName"}, method = RequestMethod.GET)
    public List<CommentLike> selectByName(String username) {
        return commentLikeMapper.selectByName(username);
    }

    @RequestMapping(value = {"/selectByCommentId"}, method = RequestMethod.GET)
    public List<CommentLike> selectByCommentId(int commentId) {
        return commentLikeMapper.selectByCommentId(commentId);
    }

    @RequestMapping(value = {"/insert"}, method = RequestMethod.POST)
    public void insertCommentLike(CommentLike commentlike, HttpServletRequest request) {
        String token = request.getHeader("token");
        String username = TokenUtil.getUsername(token);
        commentlike.setUsername(username);
        commentLikeMapper.insertCommentLike(commentlike);
    }

    @RequestMapping(value = {"/delete"}, method = RequestMethod.DELETE)
    public void deleteCommentLike(int likeId) {
        commentLikeMapper.deleteCommentLike(likeId);
    }
}
