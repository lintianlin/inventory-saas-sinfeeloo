package com.sinfeeloo.inventory;

import com.sinfeeloo.inventory.base.BaseTest;
import com.sinfeeloo.inventory.controller.SupplierController;
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
public class SupplierTest extends BaseTest {

    @Autowired
    private SupplierController supplierController;

    @Test
    public void addSupplier() {
        ComResp response = supplierController.addSupplier(
                "潍坊金光供应商",
                "张起灵",
                "15763689644",
                "潍坊市高新区歌儿光电园78945",
                "供应苹果耳机",
                new User()
                );
        printResponse(response);
    }

    @Test
    public void getSupplierList() {
        ComResp resp = supplierController.getSupplierListByPage(
                "",
                "",
                10,
                1,
                "id",
                "asc");
        printResponse(resp);
    }


    @Test
    public void modifySupplier() {
        ComResp response = supplierController.modifySupplier(
                3,
                "潍坊晨光供应商",
                "张起灵",
                "15763689644",
                "潍坊市高新区歌儿光电园78945",
                "供应晨光中性笔",
                new User()
        );
        printResponse(response);
    }

    @Test
    public void deleteSupplier() {
        ComResp resp = supplierController.deleteSupplier(1,  new User());
        printResponse(resp);
    }
}
