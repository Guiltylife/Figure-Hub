package com.example.zsgc.entity;

import lombok.Data;

@Data
public class SaleInfo {
    private int saleId;
    private int merchandiseId;
    private String username;
    private String nickname;
    private String figureName;
    private double price;
    private String imgpath;
    private int figureId;

    public SaleInfo(int saleId, int merchandiseId, String username, String nickname, String figureName, double price, String imgpath, int figureId) {
        this.saleId = saleId;
        this.merchandiseId = merchandiseId;
        this.username = username;
        this.nickname = nickname;
        this.figureName = figureName;
        this.price = price;
        this.imgpath = imgpath;
        this.figureId = figureId;
    }

    @Override
    public String toString() {
        return "SaleInfo{" +
                "saleId=" + saleId +
                ", merchandiseId=" + merchandiseId +
                ", username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                ", figureName='" + figureName + '\'' +
                ", price=" + price +
                ", imgpath='" + imgpath + '\'' +
                ", figureId=" + figureId +
                '}';
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public int getMerchandiseId() {
        return merchandiseId;
    }

    public void setMerchandiseId(int merchandiseId) {
        this.merchandiseId = merchandiseId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getFigureName() {
        return figureName;
    }

    public void setFigureName(String figureName) {
        this.figureName = figureName;
    }
}
