package com.sinfeeloo.inventory.controller;

import com.sinfeeloo.inventory.base.BaseController;
import com.sinfeeloo.inventory.entity.ComResp;
import com.sinfeeloo.inventory.entity.Customer;
import com.sinfeeloo.inventory.entity.Paging;
import com.sinfeeloo.inventory.entity.User;
import com.sinfeeloo.inventory.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: mhj
 * @Desc:
 * @Date: 2018/5/3 16:58
 */
@RestController
@RequestMapping(value = "/customer")
public class CustomerController extends BaseController {

    @Autowired
    private CustomerService customerService;


    /**
     * 添加
     *
     * @param name
     * @param linkman
     * @param mobile
     * @param address
     * @param descs
     * @return
     */
    @PostMapping(value = "/add")
    public ComResp add(@RequestParam(value = "name") String name,
                       @RequestParam(value = "linkman") String linkman,
                       @RequestParam(value = "mobile") String mobile,
                       @RequestParam(value = "address") String address,
                       @RequestParam(value = "descs", required = false) String descs,
                       @RequestAttribute User user) {

        try {
            Customer customer = new Customer();
            customer.setName(name);
            customer.setLinkman(linkman);
            customer.setMobile(mobile);
            customer.setAddress(address);
            customer.setDescs(descs);
            customer.setState(1);
            customer.setUpdater(user.getAccount());
            customerService.add(customer);
            return addSuccess();
        } catch (Exception e) {
            return addError(e);
        }

    }

    /**
     * 分页查询
     *
     * @param name
     * @param limit
     * @param page
     * @param sortCode
     * @param sortRole
     * @return
     */
    @GetMapping(value = "/getCustomerListByPage")
    public ComResp getCustomerByPage(@RequestParam(value = "name", required = false) String name,
                                     @RequestParam(value = "limit", required = false, defaultValue = "20") Integer limit,
                                     @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                     @RequestParam(value = "sortCode", required = false, defaultValue = "id") String sortCode,
                                     @RequestParam(value = "sortRole", required = false, defaultValue = "ASC") String sortRole) {

        Paging<Customer> paging = new Paging<>(page, limit);
        try {
            paging.putSearch("name", name);
            putCommonPageSearchMap(paging, limit, page, sortCode, sortRole);
            customerService.getListByPage(paging);
            return querySuccess(paging);
        } catch (Exception e) {
            return queryError(e);
        }
    }


    /**
     * 修改
     *
     * @param name
     * @param linkman
     * @param mobile
     * @param address
     * @param descs
     * @return
     */
    @PostMapping(value = "/modify")
    public ComResp modify(@RequestParam(value = "id") Integer id,
                          @RequestParam(value = "name") String name,
                          @RequestParam(value = "linkman") String linkman,
                          @RequestParam(value = "mobile") String mobile,
                          @RequestParam(value = "address") String address,
                          @RequestParam(value = "descs", required = false) String descs,
                          @RequestAttribute User user) {

        try {
            Customer customer = new Customer();
            customer.setId(id);
            customer.setName(name);
            customer.setLinkman(linkman);
            customer.setMobile(mobile);
            customer.setAddress(address);
            customer.setDescs(descs);
            customer.setUpdater(user.getAccount());
            int num = customerService.update(customer);
            return modifyResult(num);
        } catch (Exception e) {
            return modifyError(e);
        }

    }


    /**
     * 修改
     *
     * @return
     */
    @PostMapping(value = "/delete")
    public ComResp delete(@RequestParam(value = "id") Integer id,
                          @RequestAttribute User user) {

        try {
            Customer customer = new Customer();
            customer.setId(id);
            customer.setUpdater(user.getAccount());
            customerService.delete(customer);
            return deleteSuccess();
        } catch (Exception e) {
            return deleteError(e);
        }
    }

    /**
     * 修改
     *
     * @return
     */
    @GetMapping(value = "/getById")
    public ComResp getById(@RequestParam(value = "id") Integer id) {

        try {
            Customer customer = customerService.getById(id);
            return ComResp.success("查询成功！", customer);
        } catch (Exception e) {
            return ComResp.error("查询失败！", e);
        }
    }


}
