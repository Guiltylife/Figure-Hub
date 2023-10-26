package com.example.zsgc.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "figure")
public class Figure {
    private int figureId;
    private String figureName;
    private int figureType;
    private double price;
    private String prop;
    private String manuName;

    public String getManuName() {
        return manuName;
    }

    public void setManuName(String manuName) {
        this.manuName = manuName;
    }

    public int getFigureId() {
        return figureId;
    }

    public void setFigureId(int figureId) {
        this.figureId = figureId;
    }

    public String getFigureName() {
        return figureName;
    }

    public void setFigureName(String figureName) {
        this.figureName = figureName;
    }

    public int getFigureType() {
        return figureType;
    }

    public void setFigureType(int figureType) {
        this.figureType = figureType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProp() {
        return prop;
    }

    public void setProp(String prop) {
        this.prop = prop;
    }

    @Override
    public String toString() {
        return "Figure{" +
                "figureId=" + figureId +
                ", figureName='" + figureName + '\'' +
                ", figureType=" + figureType +
                ", price=" + price +
                ", prop='" + prop + '\'' +
                ", manuName='" + manuName + '\'' +
                '}';
    }
}
