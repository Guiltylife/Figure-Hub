package com.example.zsgc.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "manufacturer")
public class Manufacturer {
    private String manuName;
    private String manuLink;

    public String getManuName() {
        return manuName;
    }

    public void setManuName(String manuName) {
        this.manuName = manuName;
    }

    public String getManuLink() {
        return manuLink;
    }

    public void setManuLink(String manuLink) {
        this.manuLink = manuLink;
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "manuName='" + manuName + '\'' +
                ", manuLink='" + manuLink + '\'' +
                '}';
    }
}
