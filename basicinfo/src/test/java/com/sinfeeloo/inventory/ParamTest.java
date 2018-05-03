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

//
//    @Test
//    public void modifyParam() {
//        ComResp response = paramController.modifyParam(
//                10,
//                "白居易",
//                "lby210",
//                "370283199211010121",
//                "18810578028",
//                1,
//                "1992-11-01",
//                "北京市海淀区五道口财智国际大厦9999",
//                "lbdxlwb@sina.co",
//                "采购人员",
//                "admin2"
//        );
//        printResponse(response);
//    }
//
//    @Test
//    public void deleteParam() {
//        ComResp resp = paramController.deleteParam(7, "admin2");
//        printResponse(resp);
//    }
}
