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
            ComResp response = goodsController.addGoods("西门子电冰箱G63-5781",
                    "M63-5781",
                    53,
                    57,
                    "台",
                    "太空灰",
                    "快速制冷型",
                    "塑料",
                    "5000",
                    "6060",
                    "西门子世界知名品牌",
                    2, "admin2");
            printResponse(response);
        }


    @Test
    public void getGoodsListByPage() {
        ComResp resp = goodsController.getGoodsListByPage(
                "美",
                "",
                0,
                50,
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

    @Test
    public void getGoodsDetail() {
        ComResp resp = goodsController.getGoodsDetail(6);
        printResponse(resp);
    }
}
