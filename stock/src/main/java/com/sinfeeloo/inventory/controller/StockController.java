package com.sinfeeloo.inventory.controller;

import com.sinfeeloo.inventory.base.BaseController;
import com.sinfeeloo.inventory.entity.ComResp;
import com.sinfeeloo.inventory.entity.PurchaseOrder;
import com.sinfeeloo.inventory.entity.SalesOrder;
import com.sinfeeloo.inventory.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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


    /**
     * 审核采购单
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
}
