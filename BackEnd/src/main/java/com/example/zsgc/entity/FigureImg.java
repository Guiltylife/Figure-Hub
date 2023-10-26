package com.example.zsgc.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "figureimg")
public class FigureImg {
    private int figureImgId;
    private int figureId;
    private String imgpath;

    public int getFigureImgId() {
        return figureImgId;
    }

    public void setFigureImgId(int figureImgId) {
        this.figureImgId = figureImgId;
    }

    public int getFigureId() {
        return figureId;
    }

    public void setFigureId(int figureId) {
        this.figureId = figureId;
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }
}
