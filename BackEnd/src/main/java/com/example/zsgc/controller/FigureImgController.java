package com.example.zsgc.controller;

import com.example.zsgc.entity.FigureImg;
import com.example.zsgc.mapper.FigureImgMapper;
import com.example.zsgc.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/figureimg")
public class FigureImgController {
    @Autowired
    private FigureImgMapper figureImgMapper;

    @Value("${web.upload-path}")
    private String localPath;

    @RequestMapping(value = {"/selectAll"}, method = RequestMethod.GET)
    public List<FigureImg> selectAll() {
        return figureImgMapper.selectAll();
    }

    @RequestMapping(value = {"/selectByFigureId"}, method = RequestMethod.GET)
    public List<FigureImg> selectByFigureId(int figureId) {
        return figureImgMapper.selectByFigureId(figureId);
    }

    @RequestMapping(value = {"/insert"}, method = RequestMethod.POST)
    public void insertFigureImg(FigureImg figureImg, @RequestParam("fileName") MultipartFile imgfile) {
        figureImg.setImgpath(imgfile.getOriginalFilename());
        FileUtils.upload(imgfile, localPath, imgfile.getOriginalFilename());
        figureImgMapper.insertFigureImg(figureImg);
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.PUT)
    public void updateFigureImg(FigureImg figureImg, @RequestParam("fileName") MultipartFile imgfile) {
        figureImg.setImgpath(imgfile.getOriginalFilename());
        FileUtils.upload(imgfile, localPath, imgfile.getOriginalFilename());
        figureImgMapper.updateFigureImg(figureImg);
    }

    @RequestMapping(value = {"/delete"}, method = RequestMethod.DELETE)
    public void deleteFigureImg(int figureImgId) {
        figureImgMapper.deleteFigureImg(figureImgId);
    }
}
