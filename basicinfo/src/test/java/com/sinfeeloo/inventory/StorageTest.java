package com.sinfeeloo.inventory;

import com.sinfeeloo.inventory.base.BaseTest;
import com.sinfeeloo.inventory.controller.GoodsController;
import com.sinfeeloo.inventory.controller.StorageController;
import com.sinfeeloo.inventory.entity.ComResp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author: mhj
 * @Desc:
 * @Date: 2018/4/24 17:37
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class StorageTest extends BaseTest {

    @Autowired
    private StorageController storageController;

    @Test
    public void addStorage() {
        ComResp response = storageController.addStorage(
                "潍坊1号仓库",
                "WFCK001",
                "潍坊市高新区志远路245号",
                "主要存储家用电器相关",
                8,
                "admin2");
        printResponse(response);
    }

    @Test
    public void getStorageList() {
        ComResp resp = storageController.getStorageListByPage(
                "潍坊",
                10,
                1,
                "id",
                "asc");
        printResponse(resp);
    }

}
