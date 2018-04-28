package com.sinfeeloo.inventory;

import com.sinfeeloo.inventory.base.BaseTest;
import com.sinfeeloo.inventory.controller.GoodsController;
import com.sinfeeloo.inventory.entity.ComResp;
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
    public void addGoods() {
        ComResp response = goodsController.addGoods("美的空调k550",
                "k550014",
                "空调",
                "美的",
                "台",
                "白色",
                "50匹",
                "塑料",
                "2500",
                "3000",
                "美的让生活更美丽",
                "", "admin2");
        printResponse(response);
    }

    @Test
    public void getGoodsListByPage() {
        ComResp resp = goodsController.getGoodsListByPage(
                "美",
                "",
                "",
                "",
                "",
                "",
                "",
                20,
                1,
                "name",
                "ASC");
        printResponse(resp);
    }

    @Test
    public void deleteGoods() {
        ComResp resp = goodsController.deleteGoods(1, "admin2");
        printResponse(resp);
    }
}
