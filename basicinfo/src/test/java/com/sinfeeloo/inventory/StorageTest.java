package com.sinfeeloo.inventory;

import com.sinfeeloo.inventory.base.BaseTest;
import com.sinfeeloo.inventory.controller.StorageController;
import com.sinfeeloo.inventory.entity.ComResp;
import com.sinfeeloo.inventory.entity.User;
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
                null);
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


    @Test
    public void modifyStorage() {
        ComResp resp = storageController.modifyStorage(5, "潍坊二号仓库",
                "WFCK002",
                "潍坊市高新区志远路245号",
                "主要存储家用电器相关",
                8,
                null);
        printResponse(resp);
    }

    @Test
    public void deleteStorage() {
        User user = new User();
        user.setEmployeeName("李白");
        ComResp resp = storageController.deleteStorage(2, user);
        printResponse(resp);
    }
}
