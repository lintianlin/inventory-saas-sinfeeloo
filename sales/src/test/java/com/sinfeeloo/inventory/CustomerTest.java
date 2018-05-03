package com.sinfeeloo.inventory;

import com.sinfeeloo.inventory.base.BaseTest;
import com.sinfeeloo.inventory.controller.CustomerController;
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
                "admin2"
                );
        printResponse(response);
    }

//    @Test
//    public void getCustomerList() {
//        ComResp resp = employeeController.getCustomerListByPage(
//                "刘",
//                "",
//                10,
//                1,
//                "id",
//                "asc");
//        printResponse(resp);
//    }
//
//
//    @Test
//    public void modifyCustomer() {
//        ComResp response = employeeController.modifyCustomer(
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
//    public void deleteCustomer() {
//        ComResp resp = employeeController.deleteCustomer(7, "admin2");
//        printResponse(resp);
//    }
}
