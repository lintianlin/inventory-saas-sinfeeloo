package com.sinfeeloo.inventory.base;

import com.sinfeeloo.inventory.entity.MyResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

/**
 * BaseController
 *
 * @Author: mhj
 * @Desc:
 * @Date: 2018/4/24 17:25
 */
@RestController
public abstract class BaseController {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    protected void logError(String msg, MyResponse response, Exception e) {
        response.isError(msg);
        e.printStackTrace();
        logger.error(msg + "===原因：{}", e.getStackTrace());
    }
    protected void logError(String msg,  Exception e) {
        e.printStackTrace();
        logger.error(msg + "===原因：{}", e.getStackTrace());
    }

}
