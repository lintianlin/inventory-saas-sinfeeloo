package com.sinfeeloo.inventory.controller;

import com.sinfeeloo.inventory.base.BaseController;
import com.sinfeeloo.inventory.entity.ComResp;
import com.sinfeeloo.inventory.entity.Paging;
import com.sinfeeloo.inventory.entity.Supplier;
import com.sinfeeloo.inventory.entity.User;
import com.sinfeeloo.inventory.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: mhj
 * @Desc:
 * @Date: 2018/5/3 11:37
 */
@RestController
@RequestMapping(value = "/supplier")
public class SupplierController extends BaseController {

    @Autowired
    private SupplierService supplierService;


    @PostMapping(value = "/addSupplier")
    public ComResp addSupplier(@RequestParam(value = "name") String name,
                               @RequestParam(value = "linkman") String linkman,
                               @RequestParam(value = "mobile") String mobile,
                               @RequestParam(value = "address") String address,
                               @RequestParam(value = "desc", required = false) String desc,
                               @RequestAttribute User user) {

        try {
            Supplier supplier = new Supplier();
            supplier.setName(name);
            supplier.setLinkman(linkman);
            supplier.setMobile(mobile);
            supplier.setAddress(address);
            supplier.setDescs(desc);
            supplier.setState(1);
            supplier.setUpdater(user.getAccount());
            supplierService.add(supplier);
            return addSuccess();
        } catch (Exception e) {
            return addError(e);
        }
    }

    @GetMapping(value = "/getSupplierListByPage")
    public ComResp getSupplierListByPage(@RequestParam(value = "name") String name,
                                         @RequestParam(value = "limit", required = false, defaultValue = "20") Integer limit,
                                         @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                         @RequestParam(value = "sortCode", required = false, defaultValue = "id") String sortCode,
                                         @RequestParam(value = "sortRole", required = false, defaultValue = "ASC") String sortRole) {

        Paging<Supplier> paging = new Paging<>(page, limit);
        try {
            paging.putSearch("name", name);
            putCommonPageSearchMap(paging, limit, page, sortCode, sortRole);
            supplierService.getListByPage(paging);
            return querySuccess(paging);
        } catch (Exception e) {
            return queryError(e);
        }

    }


    @PostMapping(value = "/modifySupplier")
    public ComResp modifySupplier(@RequestParam(value = "id") Integer id,
                                  @RequestParam(value = "name") String name,
                                  @RequestParam(value = "linkman") String linkman,
                                  @RequestParam(value = "mobile") String mobile,
                                  @RequestParam(value = "address") String address,
                                  @RequestParam(value = "desc", required = false) String desc,
                                  @RequestAttribute User user) {

        try {
            Supplier supplier = new Supplier();
            supplier.setId(id);
            supplier.setName(name);
            supplier.setLinkman(linkman);
            supplier.setMobile(mobile);
            supplier.setAddress(address);
            supplier.setDescs(desc);
            supplier.setUpdater(user.getAccount());
            int num = supplierService.update(supplier);
            return modifyResult(num);
        } catch (Exception e) {
            return modifyError(e);
        }
    }

    @PostMapping(value = "/deleteSupplier")
    public ComResp deleteSupplier(@RequestParam(value = "id") Integer id,
                                  @RequestAttribute User user) {
        try {
            Supplier supplier = new Supplier();
            supplier.setId(id);
            supplier.setUpdater(user.getAccount());
            supplierService.delete(supplier);
            return deleteSuccess();
        } catch (Exception e) {
            return deleteError(e);
        }
    }

    @PostMapping(value = "/getById")
    public ComResp getById(@RequestParam(value = "id") Integer id) {
        try {
            Supplier supplier = supplierService.getById(id);
            return ComResp.success("查询成功！", supplier);
        } catch (Exception e) {
            return ComResp.error("查询失败！", e);
        }
    }
}
