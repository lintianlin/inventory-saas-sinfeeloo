package com.sinfeeloo.inventory.controller;

import com.sinfeeloo.inventory.base.BaseController;
import com.sinfeeloo.inventory.entity.ComResp;
import com.sinfeeloo.inventory.entity.Goods;
import com.sinfeeloo.inventory.entity.MyResponse;
import com.sinfeeloo.inventory.entity.Paging;
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
            return ComResp.error("添加失败！", e);
        }

    }


    /**
     * 查询商品列表（分页）
     *
     * @param goodsName
     * @param goodsCode
     * @param goodsType
     * @param brand
     * @param color
     * @param standard
     * @param material
     * @param limit
     * @param page
     * @param sortCode
     * @param sortRole
     * @return
     */
    @GetMapping(value = "/getGoodsListByPage")
    public ComResp getGoodsListByPage(
            @RequestParam(value = "goodsName", required = false) String goodsName,
            @RequestParam(value = "goodsCode", required = false) String goodsCode,
            @RequestParam(value = "goodsType", required = false) String goodsType,
            @RequestParam(value = "brand", required = false) String brand,
            @RequestParam(value = "color", required = false) String color,
            @RequestParam(value = "standard", required = false) String standard,
            @RequestParam(value = "material", required = false) String material,
            @RequestParam(value = "limit", required = false, defaultValue = "20") Integer limit,
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "sortCode", required = false, defaultValue = "id") String sortCode,
            @RequestParam(value = "sortRole", required = false, defaultValue = "ASC") String sortRole) {
        Paging<Goods> paging = new Paging<>(page, limit);
        try {
            paging.putSearch("goodsName", goodsName);
            paging.putSearch("goodsCode", goodsCode);
            paging.putSearch("goodsType", goodsType);
            paging.putSearch("brand", brand);
            paging.putSearch("color", color);
            paging.putSearch("standard", standard);
            paging.putSearch("material", material);
            paging.putSearch("limit", limit);
            paging.putSearch("page", page);
            paging.putSearch("sortCode", sortCode);
            paging.putSearch("sortRole", sortRole);
            goodsService.getGoodsListByPage(paging);
            return ComResp.success("查询成功！", paging);
        } catch (Exception e) {
            return ComResp.error("查询失败！", e);
        }

    }


    @PostMapping(value = "/modifyGoods")
    public ComResp modifyGoods(
            @RequestParam(value = "id", required = true) Integer id,
            @RequestParam(value = "goodsName", required = true) String goodsName,
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
            goods.setId(id);
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
            int num = goodsService.modifyGoods(goods);
            return num > 0 ? ComResp.success("修改成功！") : ComResp.success("修改失败！");
        } catch (Exception e) {
            return ComResp.error("修改失败！", e);
        }

    }


    /**
     * 删除商品
     *
     * @param id
     * @param updater
     * @return
     */
    @PostMapping(value = "/deleteGoods")
    public ComResp deleteGoods(@RequestParam(value = "id") Integer id,
                               @RequestParam(value = "updater") String updater) {

        try {
            Goods goods = new Goods();
            goods.setId(id);
            goods.setUpdater(updater);
            goodsService.deleteGoods(goods);
            return ComResp.success("删除成功！");
        } catch (Exception e) {
            return ComResp.error("删除失败！");
        }

    }


    /**
     * 查询商品详情
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/getGoodsDetail")
    public ComResp getGoodsDetail(@RequestParam(value = "id") Integer id) {
        try {
            Goods goods = goodsService.getGoodsDetail(id);
            return ComResp.success("查询成功！", goods);
        } catch (Exception e) {
            return ComResp.error("查询失败！");
        }
    }


}
