package com.sinfeeloo.inventory.controller;

import com.sinfeeloo.inventory.base.BaseController;
import com.sinfeeloo.inventory.entity.ComResp;
import com.sinfeeloo.inventory.entity.Customer;
import com.sinfeeloo.inventory.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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


    @PostMapping(value = "/add")
    public ComResp add(@RequestParam(value = "name") String name,
                       @RequestParam(value = "linkman") String linkman,
                       @RequestParam(value = "mobile") String mobile,
                       @RequestParam(value = "address") String address,
                       @RequestParam(value = "descs", required = false) String descs,
                       @RequestParam(value = "updater") String updater) {

        try {
            Customer customer = new Customer();
            customer.setName(name);
            customer.setLinkman(linkman);
            customer.setMobile(mobile);
            customer.setAddress(address);
            customer.setDescs(descs);
            customer.setState(1);
            customer.setUpdater(updater);
            customerService.add(customer);
            return addSuccess();
        } catch (Exception e) {
            return addError(e);
        }

    }
}
