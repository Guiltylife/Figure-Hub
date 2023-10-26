package com.example.zsgc.controller;

import com.example.zsgc.entity.Merchandise;
import com.example.zsgc.entity.Result;
import com.example.zsgc.mapper.MerchandiseMapper;
import com.example.zsgc.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/merchandise")
public class MerchandiseController {
    @Autowired
    private MerchandiseMapper merchandiseMapper;

    @RequestMapping(value = {"/selectAll"}, method = RequestMethod.GET)
    public List<Merchandise> selectAll() {
        return merchandiseMapper.selectAll();
    }

    @RequestMapping(value = {"/selectByUsername"}, method = RequestMethod.GET)
    public List<Merchandise> selectByUsername(String username) {
        return merchandiseMapper.selectByUsername(username);
    }

    @RequestMapping(value = {"/selectByStatus"}, method = RequestMethod.GET)
    public List<Merchandise> selectByStatus(int status) {
        return merchandiseMapper.selectByStatus(status);
    }

    @RequestMapping(value = {"/selectByType"}, method = RequestMethod.GET)
    public List<Merchandise> selectByType(int type) {
        return merchandiseMapper.selectByType(type);
    }

    @RequestMapping(value = {"/insert"}, method = RequestMethod.POST)
    @ResponseBody
    public Result insertMerchandise(Merchandise merchandise, HttpServletRequest request) {
        Result result = new Result();
        result.setMsg("新增商品成功");
        result.setSuccess(true);
        String token = request.getHeader("token");
        result.setToken(token);
        String username = TokenUtil.getUsername(token);
        merchandise.setUsername(username);
        merchandise.setUpdateTime(new Date());
        merchandiseMapper.insertMerchandise(merchandise);
        List<Merchandise> list = selectAll();
        result.setDetail(list.get(list.size()-1));
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.PUT)
    public void updateMerchandise(Merchandise merchandise, HttpServletRequest request) {
        String token = request.getHeader("token");
        String username = TokenUtil.getUsername(token);
        merchandise.setUsername(username);
        merchandise.setUpdateTime(new Date());
        merchandiseMapper.updateMerchandise(merchandise);
    }

    @RequestMapping(value = {"/delete"}, method = RequestMethod.DELETE)
    public void deleteMerchandise(int merchandiseId) {
        merchandiseMapper.deleteMerchandise(merchandiseId);
    }
}
