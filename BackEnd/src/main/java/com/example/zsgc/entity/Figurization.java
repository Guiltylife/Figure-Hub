package com.example.zsgc.entity;

import lombok.Data;

@Data
public class Figurization {
    private int relaId;
    private int figureId;
    private int roleId;

    public Figurization(int figureId, int roleId) {
        this.figureId = figureId;
        this.roleId = roleId;
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

    @Override
    public String toString() {
        return "Figurization{" +
                "figureId=" + figureId +
                ", roleId=" + roleId +
                '}';
    }
}
