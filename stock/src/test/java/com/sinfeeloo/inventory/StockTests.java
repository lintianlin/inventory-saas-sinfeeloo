package com.sinfeeloo.inventory;

import com.sinfeeloo.inventory.base.BaseTest;
import com.sinfeeloo.inventory.controller.StockController;
import com.sinfeeloo.inventory.entity.ComResp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class StockTests extends BaseTest {

    @Autowired
    private StockController stockController;


    @Test
    public void checkPurcharOrder() {
        ComResp comResp = stockController.checkPurcharOrder(
                33,
                "admin2",
                3,
                "通过",
                "admin2"
        );
        printResponse(comResp);
    }


    @Test
    public void getStockListByPage(){
        ComResp comResp = stockController.getStockListByPage(
                "",
                0,
                10,
                1,
                "id",
                "asc"
                );
        printResponse(comResp);
    }

}
