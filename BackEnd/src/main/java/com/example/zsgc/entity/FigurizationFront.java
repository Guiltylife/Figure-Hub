package com.example.zsgc.entity;

import lombok.Data;

@Data
public class FigurizationFront {
    private int relaId;
    private int figureId;
    private int roleId;
    private String figureName;
    private String roleName;

    public FigurizationFront(int relaId, int figureId, int roleId, String figureName, String roleName) {
        this.relaId = relaId;
        this.figureId = figureId;
        this.roleId = roleId;
        this.figureName = figureName;
        this.roleName = roleName;
    }

    public int getRelaId() {
        return relaId;
    }

    public void setRelaId(int relaId) {
        this.relaId = relaId;
    }

    public int getFigureId() {
        return figureId;
    }

    public void setFigureId(int figureId) {
        this.figureId = figureId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getFigureName() {
        return figureName;
    }

    public void setFigureName(String figureName) {
        this.figureName = figureName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
