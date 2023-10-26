package com.example.zsgc.controller;

import com.example.zsgc.entity.DealComment;
import com.example.zsgc.mapper.DealCommentMapper;
import com.example.zsgc.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/dealcomment")
public class DealCommentController {
    @Autowired
    private DealCommentMapper dealCommentMapper;

    @RequestMapping(value = {"/selectAll"}, method = RequestMethod.GET)
    public List<DealComment> selectAll() {
        return dealCommentMapper.selectAll();
    }

    @RequestMapping(value = {"/selectByBuyer"}, method = RequestMethod.GET)
    public List<DealComment> selectByBuyer(String buyer) {
        return dealCommentMapper.selectByBuyer(buyer);
    }

    @RequestMapping(value = {"/selectByDealId"}, method = RequestMethod.GET)
    public List<DealComment> selectByDealId(int dealId) {
        return dealCommentMapper.selectByDealId(dealId);
    }

    @RequestMapping(value = {"/insert"}, method = RequestMethod.POST)
    public void insertDealComment(DealComment dealComment, HttpServletRequest request) {
        String token = request.getHeader("token");
        String buyer = TokenUtil.getUsername(token);
        dealComment.setBuyer(buyer);
        dealComment.setUpdateTime(new Date());
        dealCommentMapper.insertDealComment(dealComment);
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.PUT)
    public void updateDealComment(DealComment dealComment, HttpServletRequest request) {
        String token = request.getHeader("token");
        String buyer = TokenUtil.getUsername(token);
        dealComment.setBuyer(buyer);
        dealComment.setUpdateTime(new Date());
        dealCommentMapper.updateDealComment(dealComment);
    }

    @RequestMapping(value = {"/delete"}, method = RequestMethod.DELETE)
    public void deleteDealComment(int dealCommentId) {
        dealCommentMapper.deleteDealComment(dealCommentId);
    }
}
