package com.sinfeeloo.inventory.base;


import com.sinfeeloo.inventory.entity.MyResponse;
import com.sinfeeloo.inventory.utils.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;

/**
 * @Author: mhj
 * @Desc: Test父类
 * @Date: 2018/4/11 17:29
 */
public class BaseTest {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());


    protected void printResponse(MyResponse response) {
        logger.info(JsonUtil.beanToJson(response));
    }


    protected void printResponse(ResponseEntity<MyResponse> response) {
        logger.info(JsonUtil.beanToJson(response));
    }
}