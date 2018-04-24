package com.sinfeeloo.inventory.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @Author: mhj
 * @Desc:
 * @Date: 2018/4/24 17:28
 */
public class MyResponse<T> {
    public static final int SUCCESS = 200;
    public static final int ERROR = 0;

    int rc = SUCCESS;
    String des = "";
    @JsonInclude(JsonInclude.Include.NON_NULL)
    T data;

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

    public void isSuccess(String msg) {
        this.setRc(MyResponse.SUCCESS);
        this.setDes(msg);

    }

    public void isError(String msg) {
        this.setRc(MyResponse.ERROR);
        this.setDes(msg);
    }
}
