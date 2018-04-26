package com.sinfeeloo.inventory.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sinfeeloo.inventory.utils.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ComResp
 *
 * @Author: mhj
 * @Desc: 统一响应数据
 * @Date: 2018/4/25 16:53
 */
public class ComResp<T> {


    // 定义一个私有构造方法
    private ComResp() {

    }

    //定义一个静态私有变量(不初始化，不使用final关键字，使用volatile保证了多线程访问时instance变量的可见性，避免了instance初始化时其他变量属性还没赋值完时，被另外线程调用)
    private static volatile ComResp instance;

    //定义一个共有的静态方法，返回该类型实例
    public static ComResp getInstance() {
        // 对象实例化时与否判断（不使用同步代码块，instance不等于null时，直接返回对象，提高运行效率）
        if (instance == null) {
            //同步代码块（对象未初始化时，使用同步代码块，保证多线程访问时对象在第一次创建后，不再重复被创建）
            synchronized (ComResp.class) {
                //未初始化，则初始instance变量
                if (instance == null) {
                    instance = new ComResp();
                }
            }
        }
        return instance;
    }

    public static final int SUCCESS = 200;            //成功处理/返回
    public static final int ERROR = 501;            //出现错误
    public static final int ERROR_TOKEN = 502;      //Token失效
    public static final int ERROR_EXCEPTION = 503;  //其它异常
    protected static Logger logger = LoggerFactory.getLogger(ComResp.class);

    int rc = SUCCESS;
    String des = "";
    @JsonInclude(JsonInclude.Include.NON_NULL)
    T data;


    public static ComResp success(String des) {
        ComResp resp = getInstance();
        resp.setRc(SUCCESS);
        resp.setData(null);
        resp.setDes(des);
        return resp;
    }


    public static <T> ComResp success(String des, T data) {
        ComResp resp = getInstance();
        resp.setRc(SUCCESS);
        resp.setData(data);
        resp.setDes(des);
        return resp;
    }

    public static ComResp error(String msg, Exception e) {
        e.printStackTrace();
        logger.error(msg, e.getStackTrace());
        ComResp resp = getInstance();
        resp.setRc(ERROR);
        resp.setData(null);
        resp.setDes(msg);
        return resp;
    }
    public static ComResp error(String msg) {
        ComResp resp = getInstance();
        resp.setRc(ERROR);
        resp.setData(null);
        resp.setDes(msg);
        return resp;
    }

    public static ComResp errorToken() {
        ComResp resp = getInstance();
        resp.setRc(ERROR_TOKEN);
        resp.setData(null);
        resp.setDes("token失效");
        return resp;
    }

    public static ComResp errorException() {
        ComResp resp = getInstance();
        resp.setRc(ERROR_EXCEPTION);
        resp.setData(null);
        resp.setDes("发生异常错误");
        return resp;
    }

    public static ComResp errorException(Exception e) {
        ComResp resp = getInstance();
        resp.setRc(ERROR_EXCEPTION);
        resp.setData(null);
        resp.setDes("发生异常错误 : " + e.getStackTrace());
        return resp;
    }


//    public ComResp() {
//        this.rc = SUCCESS;
//        this.des = "Success";
//    }
//
//    public ComResp(String des) {
//        this.des = des;
//        this.rc = ERROR;
//    }
//
//    public ComResp(int rc, String des) {
//        this.rc = rc;
//        this.des = des;
//        this.data = null;
//    }
//
//    public ComResp(int rc, String des, T data) {
//        this.rc = rc;
//        this.des = des;
//        this.data = data;
//    }


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
