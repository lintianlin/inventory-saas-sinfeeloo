package com.sinfeeloo.inventory;

import com.sinfeeloo.inventory.base.BaseTest;
import com.sinfeeloo.inventory.controller.PurchaseOrderController;
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
public class PurchaseOrderTest extends BaseTest {

    @Autowired
    private PurchaseOrderController purchaseOrderController;

    @Test
    public void addPurchaseOrder() {
        ComResp response = purchaseOrderController.add(
                9,
                2,
                5,
                100,
                1,
                "3600",
                "360000",
                8,
                "哈哈",
                new User()
        );
        printResponse(response);
    }

    @Test
    public void getPurchaseOrderList() {
        ComResp resp = purchaseOrderController.getOrderListByPage(
                1,
                "",
                "",
                "",
                5,
                "8",
                1,
                "",
                "",
                10,
                1,
                "id",
                "asc");
        printResponse(resp);
    }


    @Test
    public void modifyPurchaseOrder() {
        ComResp response = purchaseOrderController.modify(
                26,
                9,
                2,
                "宏泰供应商",
                5,
                100,
                "3800",
                "380000",
                8,
                "哈哈666666",
                new User()
        );
        printResponse(response);
    }

    @Test
    public void deletePurchaseOrder() {
        ComResp resp = purchaseOrderController.delete(1, new User());
        printResponse(resp);
    }

    @Test
    public void chechOrder() {
        ComResp resp = purchaseOrderController.check(25, "刘德华", 3, new User());
        printResponse(resp);
    }
}
