package com.example.zsgc.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class DealFront {
    private int dealId;
    private int status;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date createTime;
    private String buyer;
    private String seller;
    private String buyernick;
    private String sellernick;
    private int merchandiseId;
    private String figureName;

    public DealFront(int dealId, int status, Date createTime, String buyer, String seller, int merchandiseId, String figureName) {
        this.dealId = dealId;
        this.status = status;
        this.createTime = createTime;
        this.buyer = buyer;
        this.seller = seller;
        this.merchandiseId = merchandiseId;
        this.figureName = figureName;
    }

    public String getBuyernick() {
        return buyernick;
    }

    public void setBuyernick(String buyernick) {
        this.buyernick = buyernick;
    }

    public String getSellernick() {
        return sellernick;
    }

    public void setSellernick(String sellernick) {
        this.sellernick = sellernick;
    }

    public int getDealId() {
        return dealId;
    }

    public void setDealId(int dealId) {
        this.dealId = dealId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public int getMerchandiseId() {
        return merchandiseId;
    }

    public void setMerchandiseId(int merchandiseId) {
        this.merchandiseId = merchandiseId;
    }

    public String getFigureName() {
        return figureName;
    }

    public void setFigureName(String figureName) {
        this.figureName = figureName;
    }
}
