package com.sinfeeloo.inventory;

import com.sinfeeloo.inventory.base.BaseTest;
import com.sinfeeloo.inventory.controller.EmployeeController;
import com.sinfeeloo.inventory.controller.EmployeeController;
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
public class EmployeeTest extends BaseTest {

    @Autowired
    private EmployeeController employeeController;

    @Test
    public void addEmployee() {
        ComResp response = employeeController.addEmployee(
                "李白",
                "lb210",
                "370283199211010111",
                "18810578028",
                1,
                "1992-11-01",
                "北京市海淀区五道口财智国际大厦9999",
                "lbdxlwb@sina.co",
                "采购人员",
                "admin2"
                );
        printResponse(response);
    }

//    @Test
//    public void getEmployeeList() {
//        ComResp resp = employeeController.getEmployeeListByPage(
//                "潍坊",
//                10,
//                1,
//                "id",
//                "asc");
//        printResponse(resp);
//    }
//
//
//    @Test
//    public void modifyEmployee() {
//        ComResp resp = employeeController.modifyEmployee(5, "潍坊二号仓库",
//                "WFCK002",
//                "潍坊市高新区志远路245号",
//                "主要存储家用电器相关",
//                8,
//                "admin2");
//        printResponse(resp);
//    }
//
//    @Test
//    public void deleteEmployee() {
//        ComResp resp = employeeController.deleteEmployee(2, "admin2");
//        printResponse(resp);
//    }
}
