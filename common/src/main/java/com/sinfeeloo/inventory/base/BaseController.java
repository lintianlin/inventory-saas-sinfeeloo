package com.sinfeeloo.inventory.base;

import com.sinfeeloo.inventory.entity.ComResp;
import com.sinfeeloo.inventory.entity.MyResponse;
import com.sinfeeloo.inventory.entity.Paging;
import javafx.beans.property.IntegerProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

/**
 * BaseController
 *
 * @Author: mhj
 * @Desc: 基类的作用：太懒了！！！多一个单词都不想写
 * @Date: 2018/4/24 17:25
 */
public abstract class BaseController {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    protected void logError(String msg, MyResponse response, Exception e) {
        response.isError(msg);
        e.printStackTrace();
        logger.error(msg + "===原因：{}", e.getStackTrace());
    }

    protected void logError(String msg, Exception e) {
        e.printStackTrace();
        logger.error(msg + "===原因：{}", e.getStackTrace());
    }

    protected ComResp addSuccess() {
        return ComResp.success("添加成功！");
    }

    protected ComResp addError(Exception e) {
        return ComResp.error("添加失败！", e);
    }

    protected ComResp modifyResult(int num) {
        return num > 0 ? ComResp.success("修改成功！") : ComResp.error("修改失败！");
    }

    protected ComResp modifySuccess() {
        return ComResp.success("修改成功！");
    }

    protected ComResp modifyError(Exception e) {
        return ComResp.error("修改失败！", e);
    }


    protected ComResp deleteSuccess() {
        return ComResp.success("删除成功！");
    }

    protected ComResp deleteError(Exception e) {
        return ComResp.success("删除失败！", e);
    }

    protected ComResp querySuccess(Paging paging) {
        return ComResp.success("查询成功！", paging);
    }

    protected ComResp queryError(Exception e) {
        return ComResp.success("查询失败！", e);
    }

    protected void putCommonPageSearchMap(Paging paging, Integer limit, Integer page, String sortCode, String sortRole) {
        paging.putSearch("limit", limit);
        paging.putSearch("page", page);
        paging.putSearch("sortCode", sortCode);
        paging.putSearch("sortRole", sortRole);
    }

}
