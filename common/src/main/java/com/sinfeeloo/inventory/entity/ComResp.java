package com.sinfeeloo.inventory.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * ComResp
 * @Author: mhj
 * @Desc:  统一响应数据
 * @Date: 2018/4/25 16:53
 */
public class ComResp<T> {

    public static final int SUCCESS = 200;            //成功处理/返回
    public static final int ERROR = 501;            //出现错误
    public static final int ERROR_TOKEN = 502;      //Token失效
    public static final int ERROR_EXCEPTION = 503;  //其它异常

    int rc = SUCCESS;
    String des = "";
    @JsonInclude(JsonInclude.Include.NON_NULL)
    T data;

    public static ComResp success() {
        return new ComResp();
    }

    public static ComResp success(String des) {
        return new ComResp(SUCCESS, des, null);
    }

    public static <T> ComResp success(T data) {
        return new ComResp(SUCCESS, "Success", data);
    }

    public static ComResp error(String des) {
        return new ComResp(des);
    }

    public static ComResp errorToken() {
        return new ComResp(ERROR_TOKEN, "token失效");
    }

    public static ComResp errorException() {
        return new ComResp(ERROR_EXCEPTION, "发生异常错误");
    }

    public static ComResp errorException(Exception e) {
        return new ComResp(ERROR_EXCEPTION, "发生异常错误 : " + e.getStackTrace());
    }

    public ComResp() {
        this.rc = SUCCESS;
        this.des = "Success";
    }

    public ComResp(String des) {
        this.des = des;
        this.rc = ERROR;
    }

    public ComResp(int rc, String des) {
        this.rc = rc;
        this.des = des;
        this.data = null;
    }

    public ComResp(int rc, String des, T data) {
        this.rc = rc;
        this.des = des;
        this.data = data;
    }

    public int getRc() {
        return rc;
    }

    public void setRc(int rc) {
        this.rc = rc;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
