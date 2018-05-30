package com.sinfeeloo.inventory;

import com.sinfeeloo.inventory.base.BaseTest;
import com.sinfeeloo.inventory.controller.SalesOrderController;
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
public class SalesOrderTest extends BaseTest {

    @Autowired
    private SalesOrderController salesOrderController;

    @Test
    public void addSalesOrder() {
        ComResp response = salesOrderController.add(
                9,
                4,
                5,
                100,
                1,
                "3600",
                "360000",
                8,
                "老龄化社会观察：当互联网企业遇到“银发族”员工",
                new User()
        );
        printResponse(response);
    }

    @Test
    public void getSalesOrderList() {
        ComResp resp = salesOrderController.getOrderListByPage(
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
    public void modifySalesOrder() {
        ComResp response = salesOrderController.modify(
                15,
                9,
                4,
                5,
                1000,
                "38000",
                "3800000",
                8,
                "科学育儿 | 每个孩子都是解决自己问题的专家",
                new User()
        );
        printResponse(response);
    }

    @Test
    public void deleteSalesOrder() {
        ComResp resp = salesOrderController.delete(1, new User());
        printResponse(resp);
    }

    @Test
    public void chechOrder() {
        ComResp resp = salesOrderController.check(15, "刘德华", 4, new User());
        printResponse(resp);
    }
}
