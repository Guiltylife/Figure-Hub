package com.example.zsgc.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "roleimg")
public class RoleImg {
    private int roleImgId;
    private int roleId;
    private String imgpath;

    public int getRoleImgId() {
        return roleImgId;
    }

    public void setRoleImgId(int roleImgId) {
        this.roleImgId = roleImgId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }
}
