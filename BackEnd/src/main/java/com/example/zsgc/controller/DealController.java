package com.example.zsgc.controller;

import com.example.zsgc.entity.Comment;
import com.example.zsgc.entity.Deal;
import com.example.zsgc.entity.DealFront;
import com.example.zsgc.entity.Merchandise;
import com.example.zsgc.mapper.DealMapper;
import com.example.zsgc.mapper.MerchandiseMapper;
import com.example.zsgc.mapper.UserMapper;
import com.example.zsgc.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/deal")
public class DealController {
    @Autowired
    private DealMapper dealMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MerchandiseMapper merchandiseMapper;

    @RequestMapping(value = {"/selectAll"}, method = RequestMethod.GET)
    public List<DealFront> selectAll() {
        List<DealFront> list = dealMapper.selectAll();
        for (DealFront dealFront : list) {
            dealFront.setBuyernick(userMapper.findUserByName(dealFront.getBuyer()).getNickname());
            dealFront.setSellernick(userMapper.findUserByName(dealFront.getSeller()).getNickname());
        }
        return list;
    }

    @RequestMapping(value = {"/selectByBuyer"}, method = RequestMethod.GET)
    public List<DealFront> selectByBuyer(String buyer) {
        List<DealFront> list = dealMapper.selectAll();
        for (DealFront dealFront : list) {
            dealFront.setBuyernick(userMapper.findUserByName(dealFront.getBuyer()).getNickname());
            dealFront.setSellernick(userMapper.findUserByName(dealFront.getSeller()).getNickname());
        }
        return dealMapper.selectByBuyer(buyer);
    }

    @RequestMapping(value = {"/selectBySeller"}, method = RequestMethod.GET)
    public List<DealFront> selectBySeller(String seller) {
        List<DealFront> list = dealMapper.selectAll();
        for (DealFront dealFront : list) {
            dealFront.setBuyernick(userMapper.findUserByName(dealFront.getBuyer()).getNickname());
            dealFront.setSellernick(userMapper.findUserByName(dealFront.getSeller()).getNickname());
        }
        return dealMapper.selectBySeller(seller);
    }

    @RequestMapping(value = {"/selectByMerchandiseId"}, method = RequestMethod.GET)
    public List<DealFront> selectByMerchandiseId(int merchandiseId) {
        List<DealFront> list = dealMapper.selectAll();
        for (DealFront dealFront : list) {
            dealFront.setBuyernick(userMapper.findUserByName(dealFront.getBuyer()).getNickname());
            dealFront.setSellernick(userMapper.findUserByName(dealFront.getSeller()).getNickname());
        }
        return dealMapper.selectByMerchandiseId(merchandiseId);
    }

    @RequestMapping(value = {"/insert"}, method = RequestMethod.POST)
    public void insertDeal(Deal deal, HttpServletRequest request) {
        String token = request.getHeader("token");
        String buyer = TokenUtil.getUsername(token);
        deal.setBuyer(buyer);
        deal.setCreateTime(new Date());
        dealMapper.insertDeal(deal);

        String seller = deal.getSeller();
        if (userMapper.findUserByName(seller).getType() == 1) {
            merchandiseMapper.updateSoldOut(deal.getMerchandiseId());
        }
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.PUT)
    public void updateDeal(Deal deal, HttpServletRequest request) {
        String token = request.getHeader("token");
        String buyer = TokenUtil.getUsername(token);
        deal.setBuyer(buyer);
        deal.setCreateTime(new Date());
        dealMapper.updateDeal(deal);
    }

    @RequestMapping(value = {"/delete"}, method = RequestMethod.DELETE)
    public void deleteDeal(int dealId) {
        dealMapper.deleteDeal(dealId);
    }
}
