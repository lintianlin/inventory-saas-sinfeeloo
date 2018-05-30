package com.sinfeeloo.inventory.controller;

import com.sinfeeloo.inventory.base.BaseController;
import com.sinfeeloo.inventory.entity.ComResp;
import com.sinfeeloo.inventory.entity.Paging;
import com.sinfeeloo.inventory.entity.SalesOrder;
import com.sinfeeloo.inventory.entity.User;
import com.sinfeeloo.inventory.service.SalesOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: mhj
 * @Desc:销售订单管理
 * @Date: 2018/5/4 8:59
 */
@RestController
@RequestMapping(value = "/salesOrder")
public class SalesOrderController extends BaseController {

    @Autowired
    private SalesOrderService salesOrderService;

    /**
     * 添加订单
     *
     * @param goodsId
     * @param customerId
     * @param respId
     * @param count
     * @param type       判断是什么类型的订单：  销售单    退货单
     * @param unitPrice
     * @param totalPrice
     * @param operatorId
     * @param descs
     * @param user
     * @return
     */
    @PostMapping(value = "/add")
    public ComResp add(@RequestParam(value = "goodsId") Integer goodsId,
                       @RequestParam(value = "customerId") Integer customerId,
                       @RequestParam(value = "respId", required = false) Integer respId,
                       @RequestParam(value = "type") Integer type,
                       @RequestParam(value = "count") Integer count,
                       @RequestParam(value = "unitPirce") String unitPrice,
                       @RequestParam(value = "totalPrice", required = false) String totalPrice,
                       @RequestParam(value = "operatorId") Integer operatorId,
                       @RequestParam(value = "descs", required = false) String descs,
                       @RequestAttribute User user) {

        try {
            SalesOrder order = new SalesOrder();
            order.setOrdernumber(salesOrderService.getSalesOrderNumber());
            order.setGoodsid(goodsId);
            order.setCustomerid(customerId);
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
            order.setUpdater(user.getAccount());
            order.setCreater(user.getAccount());
            salesOrderService.add(order);
            return addSuccess();
        } catch (Exception e) {
            return addError(e);
        }
    }


    /**
     * 分页列表
     *
     * @param type
     * @param orderNumber
     * @param goodsName
     * @param customerName
     * @param respId
     * @param operator
     * @param chechState
     * @param startTime
     * @param endTime
     * @param limit
     * @param page
     * @param sortCode
     * @param sortRole
     * @return
     */
    @GetMapping(value = "/getOrderListByPage")
    public ComResp getOrderListByPage(@RequestParam(value = "type", required = false) Integer type,
                                      @RequestParam(value = "orderNumber", required = false) String orderNumber,
                                      @RequestParam(value = "goodsName", required = false) String goodsName,
                                      @RequestParam(value = "customerName", required = false) String customerName,
                                      @RequestParam(value = "respId", required = false) Integer respId,
                                      @RequestParam(value = "operator", required = false) String operator,
                                      @RequestParam(value = "checkState", required = false) Integer chechState,
                                      @RequestParam(value = "startTime", required = false) String startTime,
                                      @RequestParam(value = "endTime", required = false) String endTime,
                                      @RequestParam(value = "limit", required = false, defaultValue = "20") Integer limit,
                                      @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                      @RequestParam(value = "sortCode", required = false, defaultValue = "id") String sortCode,
                                      @RequestParam(value = "sortRole", required = false, defaultValue = "ASC") String sortRole) {
        Paging<SalesOrder> paging = new Paging<>(page, limit);
        try {
            paging.putSearch("goodsName", goodsName);
            paging.putSearch("type", type);
            paging.putSearch("orderNumber", orderNumber);
            paging.putSearch("customerName", customerName);
            paging.putSearch("repoId", respId);
            paging.putSearch("operator", operator);
            paging.putSearch("checkState", chechState);
            paging.putSearch("startTime", startTime);
            paging.putSearch("endTime", endTime);
            putCommonPageSearchMap(paging, limit, page, sortCode, sortRole);
            salesOrderService.getListByPage(paging);
            return querySuccess(paging);
        } catch (Exception e) {
            return queryError(e);

        }
    }


    /**
     * 修改
     *
     * @param id
     * @param goodsId
     * @param customerId
     * @param respId
     * @param count
     * @param unitPrice
     * @param totalPrice
     * @param operatorId
     * @param descs
     * @param user
     * @return
     */
    @PostMapping(value = "/modify")
    public ComResp modify(@RequestParam(value = "id") Integer id,
                          @RequestParam(value = "goodsId") Integer goodsId,
                          @RequestParam(value = "customerId") Integer customerId,
                          @RequestParam(value = "respId", required = false) Integer respId,
                          @RequestParam(value = "count") Integer count,
                          @RequestParam(value = "unitPirce") String unitPrice,
                          @RequestParam(value = "totalPrice", required = false) String totalPrice,
                          @RequestParam(value = "operatorId") Integer operatorId,
                          @RequestParam(value = "descs", required = false) String descs,
                          @RequestAttribute User user) {

        try {
            SalesOrder order = new SalesOrder();
            order.setId(id);
            order.setGoodsid(goodsId);
            order.setCustomerid(customerId);
            order.setRepoid(respId);
            order.setCount(count);
            order.setUnitprice(new BigDecimal(unitPrice));
            order.setTotalprice(new BigDecimal(totalPrice));
            order.setEmployeeid(operatorId);
            order.setDescs(descs);
            order.setUpdater(user.getAccount());
            int num = salesOrderService.update(order);
            return modifyResult(num);
        } catch (Exception e) {
            return modifyError(e);
        }
    }

    /**
     * 删除
     *
     * @param id
     * @param user
     * @return
     */
    @PostMapping(value = "/delete")
    public ComResp delete(@RequestParam(value = "id") Integer id,
                          @RequestAttribute User user) {
        try {
            SalesOrder order = new SalesOrder();
            order.setId(id);
            order.setUpdater(user.getAccount());
            salesOrderService.delete(order);
            return deleteSuccess();
        } catch (Exception e) {
            return deleteError(e);
        }
    }

    /**
     * 订单详情
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/getById")
    public ComResp getById(@RequestParam(value = "id") Integer id) {
        try {
            SalesOrder salesOrder = salesOrderService.getById(id);
            return ComResp.success("查询成功！", salesOrder);
        } catch (Exception e) {
            return ComResp.success("查询失败！", e);
        }
    }


    /**
     * 审核
     *
     * @param id
     * @param checkAccount
     * @param checkState
     * @param user
     * @return
     */
    @PostMapping(value = "/check")
    public ComResp check(@RequestParam(value = "id") Integer id,
                         @RequestParam(value = "checkState") Integer checkState,
                         @RequestAttribute User user) {
        try {
            SalesOrder order = new SalesOrder();
            order.setId(id);
            order.setCheckaccount(user.getAccount());
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
            order.setUpdater(user.getAccount());

            int num = salesOrderService.check(order);
            return modifyResult(num);
        } catch (Exception e) {
            return modifyError(e);
        }
    }


    /**
     * 分页列表
     *
     * @param type
     * @param orderNumber
     * @param goodsName
     * @param customerName
     * @param respId
     * @param operator
     * @param startTime
     * @param endTime
     * @param limit
     * @param page
     * @param sortCode
     * @param sortRole
     * @return
     */
    @GetMapping(value = "/getCheckOrderListByPage")
    public ComResp getCheckOrderListByPage(@RequestParam(value = "type", required = false) Integer type,
                                           @RequestParam(value = "orderNumber", required = false) String orderNumber,
                                           @RequestParam(value = "goodsName", required = false) String goodsName,
                                           @RequestParam(value = "customerName", required = false) String customerName,
                                           @RequestParam(value = "respId", required = false) Integer respId,
                                           @RequestParam(value = "operator", required = false) String operator,
                                           @RequestParam(value = "startTime", required = false) String startTime,
                                           @RequestParam(value = "endTime", required = false) String endTime,
                                           @RequestParam(value = "limit", required = false, defaultValue = "20") Integer limit,
                                           @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                           @RequestParam(value = "sortCode", required = false, defaultValue = "id") String sortCode,
                                           @RequestParam(value = "sortRole", required = false, defaultValue = "ASC") String sortRole) {
        Paging<SalesOrder> paging = new Paging<>(page, limit);
        try {
            paging.putSearch("goodsName", goodsName);
            paging.putSearch("type", type);
            paging.putSearch("orderNumber", orderNumber);
            paging.putSearch("customerName", customerName);
            paging.putSearch("repoId", respId);
            paging.putSearch("operator", operator);
            paging.putSearch("startTime", startTime);
            paging.putSearch("endTime", endTime);
            putCommonPageSearchMap(paging, limit, page, sortCode, sortRole);
            salesOrderService.getCheckListByPage(paging);
            return querySuccess(paging);
        } catch (Exception e) {
            return queryError(e);

        }
    }

}
