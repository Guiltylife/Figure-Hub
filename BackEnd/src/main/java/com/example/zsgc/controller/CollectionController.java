package com.example.zsgc.controller;

import com.example.zsgc.entity.Collection;
import com.example.zsgc.mapper.CollectionMapper;
import com.example.zsgc.mapper.CollectionMapper;
import com.example.zsgc.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/collection")
public class CollectionController {
    @Autowired
    private CollectionMapper collectionMapper;

    @RequestMapping(value = {"/selectAll"}, method = RequestMethod.GET)
    public List<Collection> selectAll() {
        return collectionMapper.selectAll();
    }

    @RequestMapping(value = {"/selectByUsername"}, method = RequestMethod.GET)
    public List<Collection> selectByUsername(String username) {
        return collectionMapper.selectByUsername(username);
    }

    @RequestMapping(value = {"/selectByMerchandiseId"}, method = RequestMethod.GET)
    public List<Collection> selectByMerchandiseId(int merchandiseId) {
        return collectionMapper.selectByMerchandiseId(merchandiseId);
    }

    @RequestMapping(value = {"/insert"}, method = RequestMethod.POST)
    public void insertCollection(Collection collection, HttpServletRequest request) {
        String token = request.getHeader("token");
        String username = TokenUtil.getUsername(token);
        collection.setUsername(username);
        collectionMapper.insertCollection(collection);
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.PUT)
    public void updateCollection(Collection collection, HttpServletRequest request) {
        String token = request.getHeader("token");
        String username = TokenUtil.getUsername(token);
        collection.setUsername(username);
        collectionMapper.updateCollection(collection);
    }

    @RequestMapping(value = {"/delete"}, method = RequestMethod.DELETE)
    public void deleteCollection(int coID) {
        collectionMapper.deleteCollection(coID);
    }
}
