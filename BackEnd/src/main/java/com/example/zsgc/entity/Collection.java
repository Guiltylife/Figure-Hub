package com.example.zsgc.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "collection")
public class Collection {
    private int coID;
    private String username;
    private int merchandiseId;

    public int getCoID() {
        return coID;
    }

    public void setCoID(int coID) {
        this.coID = coID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getMerchandiseId() {
        return merchandiseId;
    }

    public void setMerchandiseId(int merchandiseId) {
        this.merchandiseId = merchandiseId;
    }

    @Override
    public String toString() {
        return "Collection{" +
                "username='" + username + '\'' +
                ", merchandiseId=" + merchandiseId +
                '}';
    }
}
