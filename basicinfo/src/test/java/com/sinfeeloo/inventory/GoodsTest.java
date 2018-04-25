package com.sinfeeloo.inventory;

import com.sinfeeloo.inventory.base.BaseTest;
import com.sinfeeloo.inventory.controller.GoodsController;
import com.sinfeeloo.inventory.entity.Goods;
import com.sinfeeloo.inventory.entity.MyResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Author: mhj
 * @Desc:
 * @Date: 2018/4/24 17:37
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GoodsTest extends BaseTest {

    @Autowired
    private GoodsController goodsController;

    @Test
    public void getAllGoods() {
        MyResponse<List<Goods>> response = goodsController.getAllGoods();
        printResponse(response);
    }
}
