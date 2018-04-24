package com.sinfeeloo.inventory.controller;

import com.sinfeeloo.inventory.base.BaseController;
import com.sinfeeloo.inventory.entity.Goods;
import com.sinfeeloo.inventory.entity.MyResponse;
import com.sinfeeloo.inventory.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: mhj
 * @Desc:
 * @Date: 2018/4/24 17:25
 */
@RestController
@RequestMapping(value = "/goods")
public class GoodsController extends BaseController {


    @Autowired
    private GoodsService goodsService;


    @GetMapping(value = "/getAllGoods")
    public MyResponse<List<Goods>> getAllGoods() {
        MyResponse response = new MyResponse();
        try {
            response.setData(goodsService.getGoodsList());
            response.isSuccess("查询成功！");
        } catch (Exception e) {
            logError("查询失败", response, e);
        }

        return response;
    }
}
