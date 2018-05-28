package com.sinfeeloo.inventory;

import com.sinfeeloo.inventory.base.BaseTest;
import com.sinfeeloo.inventory.controller.ParamController;
import com.sinfeeloo.inventory.controller.ParamController;
import com.sinfeeloo.inventory.entity.ComResp;
import com.sinfeeloo.inventory.entity.User;
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
                1,
                "西门子",
                "品牌",
                new User()
                );
        printResponse(response);
    }

    @Test
    public void getParamList() {
        ComResp resp = paramController.getParamListByPage(
                "",
                0,
                10,
                1,
                "id",
                "asc");
        printResponse(resp);
    }


    @Test
    public void modifyParam() {
        ComResp response = paramController.modifyParam(
                50,
                2,
                "海信",
                "修改品牌",
                new User()
        );
        printResponse(response);
    }

    @Test
    public void deleteParam() {
        ComResp resp = paramController.deleteParam(50, new User());
        printResponse(resp);
    }
}
