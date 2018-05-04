package com.sinfeeloo.inventory.controller;

import com.sinfeeloo.inventory.base.BaseController;
import com.sinfeeloo.inventory.entity.*;
import com.sinfeeloo.inventory.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: mhj
 * @Desc:
 * @Date: 2018/5/4 10:32
 */
@RestController
@RequestMapping(value = "/stock")
public class StockController extends BaseController {

    @Autowired
    private StockService stockService;


    @GetMapping(value = "/getStockListByPage")
    public ComResp getStockListByPage(@RequestParam(value = "goodsName", required = false) String goodsName,
                                      @RequestParam(value = "repoId", required = false) Integer repoId,
                                      @RequestParam(value = "limit", required = false, defaultValue = "20") Integer limit,
                                      @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                      @RequestParam(value = "sortCode", required = false, defaultValue = "id") String sortCode,
                                      @RequestParam(value = "sortRole", required = false, defaultValue = "ASC") String sortRole) {

        Paging<Stock> paging = new Paging<>(page, limit);
        try {
            paging.putSearch("goodsName", goodsName);
            paging.putSearch("repoId", repoId);
            putCommonPageSearchMap(paging, limit, page, sortCode, sortRole);
            stockService.getListByPage(paging);
            return querySuccess(paging);
        } catch (Exception e) {
            return queryError(e);
        }

    }


    /**
     * 审核采购单
     *
     * @param id
     * @param checkAccount
     * @param checkState
     * @param checkResult
     * @param updater
     * @return
     */
    @PostMapping(value = "/checkPurcharOrder")
    public ComResp checkPurcharOrder(@RequestParam(value = "id") Integer id,
                                     @RequestParam(value = "checkAccount") String checkAccount,
                                     @RequestParam(value = "checkState") Integer checkState,
                                     @RequestParam(value = "checkResult") String checkResult,
                                     @RequestParam(value = "updater") String updater) {
        try {
            PurchaseOrder order = new PurchaseOrder();
            order.setId(id);
            order.setCheckaccount(checkAccount);
            order.setCheckstate(checkState);
            if (checkState == 2) {//不通过
                order.setCheckresult(checkResult);
            } else if (checkState == 3) {//通过
                order.setCheckresult(checkResult);
                //审核通过后更新入库时间
                order.setTaketime(new Date());
            } else {
                return ComResp.error("审核状态错误！");
            }
            order.setUpdater(updater);
            int num = stockService.checkPurchaseOrder(order);
            return num > 0 ? ComResp.success("审核成功！") : ComResp.error("审核失败！");
        } catch (Exception e) {
            return ComResp.error("审核失败！", e);
        }
    }


    /**
     * 审核销售单
     *
     * @param id
     * @param checkAccount
     * @param checkState
     * @param checkResult
     * @param updater
     * @return
     */
    @PostMapping(value = "/checkSalesOrder")
    public ComResp checkSalesOrder(@RequestParam(value = "id") Integer id,
                                   @RequestParam(value = "checkAccount") String checkAccount,
                                   @RequestParam(value = "checkState") Integer checkState,
                                   @RequestParam(value = "checkResult") String checkResult,
                                   @RequestParam(value = "updater") String updater) {
        try {
            SalesOrder order = new SalesOrder();
            order.setId(id);
            order.setCheckaccount(checkAccount);
            order.setCheckstate(checkState);
            if (checkState == 2) {//不通过
                order.setCheckresult(checkResult);
            } else if (checkState == 3) {//通过
                order.setCheckresult(checkResult);
                //审核通过后更新入库时间
                order.setTaketime(new Date());
            } else {
                return ComResp.error("审核状态错误！");
            }
            order.setUpdater(updater);
            int num = stockService.checkSalesOrder(order);
            if (num < 0) {
                return ComResp.error("库存不足");
            }
            return num > 0 ? ComResp.success("审核成功！") : ComResp.error("审核失败！");
        } catch (Exception e) {
            return ComResp.error("审核失败！", e);
        }
    }


    /**
     * 修改价格
     * @param id
     * @param avgBuyPrice
     * @param salePrice
     * @return
     */
    @PostMapping(value = "/modifyPrice")
    public ComResp modifyPrice(@RequestParam(value = "id") Integer id,
                               @RequestParam(value = "avgBuyPrice") String avgBuyPrice,
                               @RequestParam(value = "salePrice")String salePrice){

        try{
            int num = stockService.modifyPrice(id,avgBuyPrice,salePrice);
            return modifyResult(num);
        }catch (Exception e){
            return modifyError(e);
        }

    }
}
