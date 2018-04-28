package com.sinfeeloo.inventory.controller;

import com.sinfeeloo.inventory.base.BaseController;
import com.sinfeeloo.inventory.entity.ComResp;
import com.sinfeeloo.inventory.entity.Goods;
import com.sinfeeloo.inventory.entity.MyResponse;
import com.sinfeeloo.inventory.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: mhj
 * @Desc:商品管理
 * @Date: 2018/4/24 17:25
 */
@RestController
@RequestMapping(value = "/goods")
public class GoodsController extends BaseController {


    @Autowired
    private GoodsService goodsService;


    @PostMapping(value = "/addGoods")
    public ComResp addGoods(@RequestParam(value = "goodsName", required = true) String goodsName,
                            @RequestParam(value = "goodsCode", required = true) String goodsCode,
                            @RequestParam(value = "goodsType", required = true) String goodsType,
                            @RequestParam(value = "brand", required = false, defaultValue = "") String brand,
                            @RequestParam(value = "unit", required = false, defaultValue = "") String unit,
                            @RequestParam(value = "color", required = false) String color,
                            @RequestParam(value = "standard", required = false) String standard,
                            @RequestParam(value = "material", required = false) String material,
                            @RequestParam(value = "buyPrice", required = false) String bugPrice,
                            @RequestParam(value = "sellPrice", required = false) String sellPrice,
                            @RequestParam(value = "desc", required = false) String desc,
                            @RequestParam(value = "picture", required = false) String picture,
                            @RequestParam(value = "updater", required = true) String updater) {
        try {
            Goods goods = new Goods();
            goods.setName(goodsName);
            goods.setCode(goodsCode);
            goods.setType(goodsType);
            goods.setBrand(brand);
            goods.setUnit(unit);
            goods.setColor(color);
            goods.setStandard(standard);
            goods.setMaterial(material);
            goods.setBuyprice(bugPrice);
            goods.setSaleprice(sellPrice);
            goods.setDescs(desc);
            goods.setPicture(picture);
            goods.setUpdater(updater);
            goods.setState(1);
            goodsService.addGoods(goods);
            return ComResp.success("添加成功！");
        } catch (Exception e) {
            return ComResp.error("添加失败！");
        }

    }

}
