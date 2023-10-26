package com.example.zsgc.entity;

import lombok.Data;

@Data
public class User {
    private String username;
    private String password;
    private String nickname;
    private String token;
    private int type;
    private String imgpath;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.nickname = username;
    }
    
//
//    public User(String username, String password, String nickname, int type) {
//        this.username = username;
//        this.password = password;
//        this.nickname = nickname;
//        this.type = type;
//    }


    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", token='" + token + '\'' +
                ", type=" + type +
                '}';
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
