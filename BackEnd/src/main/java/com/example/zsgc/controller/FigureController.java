package com.example.zsgc.controller;

import com.example.zsgc.entity.Figure;
import com.example.zsgc.entity.Figurization;
import com.example.zsgc.mapper.FigureMapper;
import com.example.zsgc.mapper.FigurizationMapper;
import com.example.zsgc.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/figure")
public class FigureController {
    @Autowired
    private FigureMapper figureMapper;

    @RequestMapping(value = {"/selectAll"}, method = RequestMethod.GET)
    public List<Figure> selectAll() {
        return figureMapper.selectAll();
    }

    @RequestMapping(value = {"/selectById"}, method = RequestMethod.GET)
    public Figure selectByFigureId(int figureId) {
        return figureMapper.selectByFigureId(figureId);
    }

    @RequestMapping(value = {"/selectByName"}, method = RequestMethod.GET)
    public List<Figure> selectByName(String figureName) {
        return figureMapper.selectByName(figureName);
    }

    @RequestMapping(value = {"/selectByType"}, method = RequestMethod.GET)
    public List<Figure> selectByType(int figureType) {
        return figureMapper.selectByType(figureType);
    }

    @RequestMapping(value = {"/selectByPrice"}, method = RequestMethod.GET)
    public List<Figure> selectByPrice(double price) {
        return figureMapper.selectByPrice(price);
    }

    @RequestMapping(value = {"/selectByProp"}, method = RequestMethod.GET)
    public List<Figure> selectByProp(String prop) {
        return figureMapper.selectByProp(prop);
    }

    @RequestMapping(value = {"/selectByManuName"}, method = RequestMethod.GET)
    public List<Figure> selectByManuName(String manuName) {
        return figureMapper.selectByManuName(manuName);
    }

    @RequestMapping(value = {"/insert"}, method = RequestMethod.POST)
    public void insertFigure(Figure figure, HttpServletRequest request) {
        String token = request.getHeader("token");
        String manuName = TokenUtil.getUsername(token);
        figure.setManuName(manuName);
        figureMapper.insertFigure(figure);
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.PUT)
    public void updateFigure(Figure figure, HttpServletRequest request) {
        String token = request.getHeader("token");
        String manuName = TokenUtil.getUsername(token);
        figure.setManuName(manuName);
        figureMapper.updateFigure(figure);
    }

    @RequestMapping(value = {"/delete"}, method = RequestMethod.DELETE)
    public void deleteFigure(int figureId) {
        figureMapper.deleteFigure(figureId);
    }

}
