package com.example.zsgc.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "merchandiseimg")
public class MerchandiseImg {
    private int merchandiseImgId;
    private int merchandiseId;
    private String imgpath;

    public int getMerchandiseImgId() {
        return merchandiseImgId;
    }

    public void setMerchandiseImgId(int merchandiseImgId) {
        this.merchandiseImgId = merchandiseImgId;
    }

    public int getMerchandiseId() {
        return merchandiseId;
    }

    public void setMerchandiseId(int merchandiseId) {
        this.merchandiseId = merchandiseId;
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }
}
