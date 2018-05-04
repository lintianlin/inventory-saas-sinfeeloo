package com.sinfeeloo.inventory.controller;

import com.sinfeeloo.inventory.base.BaseController;
import com.sinfeeloo.inventory.entity.ComResp;
import com.sinfeeloo.inventory.entity.Paging;
import com.sinfeeloo.inventory.entity.PurchaseOrder;
import com.sinfeeloo.inventory.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: mhj
 * @Desc:
 * @Date: 2018/5/3 14:35
 */
@RestController
@RequestMapping(value = "/purchaseOrder")
public class PurchaseOrderController extends BaseController {

    @Autowired
    private PurchaseOrderService purchaseOrderService;


    /**
     * 添加订单
     * @param goodsId
     * @param supplierId
     * @param supplierName
     * @param respId
     * @param type  判断是什么类型的订单：  进货单    退货单
     * @param count
     * @param unitPrice
     * @param totalPrice
     * @param operatorId
     * @param descs
     * @param updater
     * @return
     */
    @PostMapping(value = "/add")
    public ComResp add(@RequestParam(value = "goodsId") Integer goodsId,
                       @RequestParam(value = "supplierId") Integer supplierId,
                       @RequestParam(value = "supplierName") String supplierName,
                       @RequestParam(value = "respId", required = false) Integer respId,
                       @RequestParam(value = "type") Integer type,
                       @RequestParam(value = "count") Integer count,
                       @RequestParam(value = "unitPirce") String unitPrice,
                       @RequestParam(value = "totalPrice", required = false) String totalPrice,
                       @RequestParam(value = "operatorId") Integer operatorId,
                       @RequestParam(value = "descs", required = false) String descs,
                       @RequestParam(value = "updater") String updater) {

        try {
            PurchaseOrder order = new PurchaseOrder();
            order.setOrdernumber(purchaseOrderService.getPurchaseOrderNumber());
            order.setGoodsid(goodsId);
            order.setSupplierid(supplierId);
            order.setSuppliername(supplierName);
            order.setRepoid(respId);
            order.setCount(count);
            order.setUnitprice(new BigDecimal(unitPrice));
            order.setTotalprice(new BigDecimal(totalPrice));
            order.setEmployeeid(operatorId);
            order.setDescs(descs);
            order.setType(type);
            order.setState(1);
            order.setCheckstate(1);
            order.setCheckresult("未审核");
            order.setUpdater(updater);
            order.setCreater(updater);

            purchaseOrderService.add(order);
            return addSuccess();
        } catch (Exception e) {
            return addError(e);
        }
    }


    @GetMapping(value = "/getOrderListByPage")
    public ComResp getOrderListByPage(@RequestParam(value = "type", required = false) Integer type,
                                      @RequestParam(value = "orderNumber", required = false) String orderNumber,
                                      @RequestParam(value = "goodsName", required = false) String goodsName,
                                      @RequestParam(value = "supplierName", required = false) String supplierName,
                                      @RequestParam(value = "respId", required = false) Integer respId,
                                      @RequestParam(value = "operator", required = false) String operator,
                                      @RequestParam(value = "checkState", required = false) Integer chechState,
                                      @RequestParam(value = "startTime", required = false) String startTime,
                                      @RequestParam(value = "endTime", required = false) String endTime,
                                      @RequestParam(value = "limit", required = false, defaultValue = "20") Integer limit,
                                      @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                      @RequestParam(value = "sortCode", required = false, defaultValue = "id") String sortCode,
                                      @RequestParam(value = "sortRole", required = false, defaultValue = "ASC") String sortRole) {
        Paging<PurchaseOrder> paging = new Paging<>(page, limit);
        try {
            paging.putSearch("goodsName", goodsName);
            paging.putSearch("type", type);
            paging.putSearch("orderNumber", orderNumber);
            paging.putSearch("supplierName", supplierName);
            paging.putSearch("repoId", respId);
            paging.putSearch("operator", operator);
            paging.putSearch("checkState", chechState);
            paging.putSearch("startTime", startTime);
            paging.putSearch("endTime", endTime);
            putCommonPageSearchMap(paging, limit, page, sortCode, sortRole);
            purchaseOrderService.getListByPage(paging);
            return querySuccess(paging);
        } catch (Exception e) {
            return queryError(e);

        }
    }


    @PostMapping(value = "/modify")
    public ComResp modify(@RequestParam(value = "id") Integer id,
                          @RequestParam(value = "goodsId") Integer goodsId,
                          @RequestParam(value = "supplierId") Integer supplierId,
                          @RequestParam(value = "supplierName") String supplierName,
                          @RequestParam(value = "respId", required = false) Integer respId,
                          @RequestParam(value = "count") Integer count,
                          @RequestParam(value = "unitPirce") String unitPrice,
                          @RequestParam(value = "totalPrice", required = false) String totalPrice,
                          @RequestParam(value = "operatorId") Integer operatorId,
                          @RequestParam(value = "descs", required = false) String descs,
                          @RequestParam(value = "updater") String updater) {

        try {
            PurchaseOrder order = new PurchaseOrder();
            order.setId(id);
            order.setGoodsid(goodsId);
            order.setSupplierid(supplierId);
            order.setSuppliername(supplierName);
            order.setRepoid(respId);
            order.setCount(count);
            order.setUnitprice(new BigDecimal(unitPrice));
            order.setTotalprice(new BigDecimal(totalPrice));
            order.setEmployeeid(operatorId);
            order.setDescs(descs);
            order.setUpdater(updater);
            int num = purchaseOrderService.update(order);
            return modifyResult(num);
        } catch (Exception e) {
            return modifyError(e);
        }
    }


    @PostMapping(value = "/delete")
    public ComResp delete(@RequestParam(value = "id") Integer id,
                          @RequestParam(value = "updater") String updater) {
        try {
            PurchaseOrder order = new PurchaseOrder();
            order.setId(id);
            order.setUpdater(updater);
            purchaseOrderService.delete(order);
            return deleteSuccess();
        } catch (Exception e) {
            return deleteError(e);
        }
    }


    @PostMapping(value = "/check")
    public ComResp check(@RequestParam(value = "id") Integer id,
                         @RequestParam(value = "checkAccount") String checkAccount,
                         @RequestParam(value = "checkState") Integer checkState,
                         @RequestParam(value = "updater") String updater) {
        try {
            PurchaseOrder order = new PurchaseOrder();
            order.setId(id);
            order.setCheckaccount(checkAccount);
            order.setCheckstate(checkState);
            if (checkState == 2) {
                order.setCheckresult("不通过");
            } else if (checkState == 3) {
                order.setCheckresult("通过");
                //审核通过后更新入库时间
                order.setTaketime(new Date());
            } else if (checkState == 4) {
                order.setCheckresult("审核中");
            } else {
                return ComResp.error("审核状态错误！");
            }
            order.setUpdater(updater);

            int num = purchaseOrderService.check(order);
            return modifyResult(num);
        } catch (Exception e) {
            return modifyError(e);
        }
    }

}
