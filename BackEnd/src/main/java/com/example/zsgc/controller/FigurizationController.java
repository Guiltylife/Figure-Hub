package com.example.zsgc.controller;

import com.example.zsgc.entity.Figure;
import com.example.zsgc.entity.Figurization;
import com.example.zsgc.entity.FigurizationFront;
import com.example.zsgc.mapper.FigurizationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/figurization")
public class FigurizationController {
    @Autowired
    private FigurizationMapper figurizationMapper;

    @RequestMapping(value = {"/selectAll"}, method = RequestMethod.GET)
    public List<FigurizationFront> selectAll() {
        return figurizationMapper.selectAll();
    }

    @RequestMapping(value = {"/selectByFigureId"}, method = RequestMethod.GET)
    public List<Figurization> selectByFigureId(int figureId) {
        return figurizationMapper.selectByFigureId(figureId);
    }

    @RequestMapping(value = {"/selectByRoleId"}, method = RequestMethod.GET)
    public List<Figurization> selectByRoleId(int roleId) {
        return figurizationMapper.selectByRoleId(roleId);
    }

    @RequestMapping(value = {"/insert"}, method = RequestMethod.POST)
    public void insertFigurization(Figurization figurization) {
        figurizationMapper.insertFigurization(figurization);
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.PUT)
    public void updateFigurization(Figurization figurization) {
        figurizationMapper.updateFigurization(figurization);
    }

    @RequestMapping(value = {"/delete"}, method = RequestMethod.DELETE)
    public void deleteFigurization(int relaId) {
        figurizationMapper.deleteFigurization(relaId);
    }
}
