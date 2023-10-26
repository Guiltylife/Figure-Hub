package com.example.zsgc.entity;

public class Result<T> {
    private String msg;
    private boolean success;
    private String token;
    private T detail;

    @Override
    public String toString() {
        return "Result{" +
                "msg='" + msg + '\'' +
                ", success=" + success +
                ", token='" + token + '\'' +
                ", detail=" + detail +
                '}';
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public T getDetail() {
        return detail;
    }

    public void setDetail(T detail) {
        this.detail = detail;
    }
}
