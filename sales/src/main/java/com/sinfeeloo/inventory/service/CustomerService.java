package com.sinfeeloo.inventory.service;

import com.sinfeeloo.inventory.base.BaseServiceImpl;
import com.sinfeeloo.inventory.entity.Customer;
import com.sinfeeloo.inventory.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: mhj
 * @Desc:
 * @Date: 2018/5/3 16:55
 */
@Service
public class CustomerService extends BaseServiceImpl<Customer> {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    protected List<Customer> selectListByPage(Map<String, Object> searchMap) {
        return customerMapper.selectCustomerListByPage(searchMap);
    }

    @Override
    protected long selectListCount(Map<String, Object> searchMap) {
        return customerMapper.selectCustomerListCount(searchMap);
    }

    @Override
    public void add(Customer customer) {
        customerMapper.insert(customer);
    }

    @Override
    public int update(Customer customer) {
        return customerMapper.updateByPrimaryKey(customer);
    }

    @Override
    public int delete(Customer customer) {
        return customerMapper.deleteByPrimaryKey(customer);
    }

    public Customer getById(Integer id) {
        return customerMapper.selectByPrimaryKey(id);
    }
}
