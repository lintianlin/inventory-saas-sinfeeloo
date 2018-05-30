package com.sinfeeloo.inventory;

import com.sinfeeloo.inventory.base.BaseTest;
import com.sinfeeloo.inventory.controller.CustomerController;
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
public class CustomerTest extends BaseTest {

    @Autowired
    private CustomerController employeeController;

    @Test
    public void addCustomer() {
        ComResp response = employeeController.add(
                "北京三仙国际",
                "马华驹",
                "18810578028",
                "北京市海淀区五道口5478",
                "国际化大公司",
                new User()
                );
        printResponse(response);
    }

    @Test
    public void getCustomerList() {
        ComResp resp = employeeController.getCustomerByPage(
                "三",
                10,
                1,
                "id",
                "asc");
        printResponse(resp);
    }


    @Test
    public void modifyCustomer() {
        ComResp response = employeeController.modify(
                4,
                "北京思贤国际",
                "刘德华",
                "18810578028",
                "北京市五道口财智国际大厦17",
                "牛逼的公司",
                new User()
        );
        printResponse(response);
    }

    @Test
    public void deleteCustomer() {
        ComResp resp = employeeController.delete(1, new User());
        printResponse(resp);
    }
}
