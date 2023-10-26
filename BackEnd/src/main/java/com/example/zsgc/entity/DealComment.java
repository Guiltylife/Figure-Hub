package com.example.zsgc.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@ConfigurationProperties(prefix = "dealcomment")
public class DealComment {
    private int dealCommentId;
    private String buyer;
    private int dealId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date updateTime;
    private String content;

    public int getDealCommentId() {
        return dealCommentId;
    }

    public void setDealCommentId(int dealCommentId) {
        this.dealCommentId = dealCommentId;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public int getDealId() {
        return dealId;
    }

    public void setDealId(int dealId) {
        this.dealId = dealId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "DealComment{" +
                "dealCommentId=" + dealCommentId +
                ", buyer='" + buyer + '\'' +
                ", dealId=" + dealId +
                ", updateTime=" + updateTime +
                ", content='" + content + '\'' +
                '}';
    }
}
