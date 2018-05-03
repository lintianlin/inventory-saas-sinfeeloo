package com.sinfeeloo.inventory;

import com.sinfeeloo.inventory.base.BaseTest;
import com.sinfeeloo.inventory.controller.ParamController;
import com.sinfeeloo.inventory.controller.ParamController;
import com.sinfeeloo.inventory.entity.ComResp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author: mhj
 * @Desc:参数管理
 * @Date: 2018/4/24 17:37
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ParamTest extends BaseTest {

    @Autowired
    private ParamController paramController;

    @Test
    public void addParam() {
        ComResp response = paramController.addParam(
                "计量单位",
                "台",
                "一台",
                "admin2"
                );
        printResponse(response);
    }

    @Test
    public void getParamList() {
        ComResp resp = paramController.getParamListByPage(
                "",
                "",
                10,
                1,
                "id",
                "asc");
        printResponse(resp);
    }


    @Test
    public void modifyParam() {
        ComResp response = paramController.modifyParam(
                49,
                "计量单位",
                "吨",
                "一吨",
                "admin2"
        );
        printResponse(response);
    }

    @Test
    public void deleteParam() {
        ComResp resp = paramController.deleteParam(49, "admin2");
        printResponse(resp);
    }
}
