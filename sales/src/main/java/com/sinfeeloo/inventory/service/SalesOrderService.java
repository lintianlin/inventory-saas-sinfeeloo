package com.sinfeeloo.inventory.service;

import com.sinfeeloo.inventory.base.BaseServiceImpl;
import com.sinfeeloo.inventory.entity.SalesOrder;
import com.sinfeeloo.inventory.mapper.SalesOrderMapper;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author: mhj
 * @Desc:销售订单
 * @Date: 2018/5/4 8:59
 */
@Service
public class SalesOrderService extends BaseServiceImpl<SalesOrder> {
    
    @Autowired
    private SalesOrderMapper salesOrderMapper;
    @Override
    protected List<SalesOrder> selectListByPage(Map<String, Object> searchMap) {
        return salesOrderMapper.selectOrderListByPage(searchMap);
    }

    @Override
    protected long selectListCount(Map<String, Object> searchMap) {
        return salesOrderMapper.selectOrderListCount(searchMap);
    }

    @Override
    public void add(SalesOrder purchaseOrder) {
        salesOrderMapper.insert(purchaseOrder);
    }

    @Override
    public int update(SalesOrder purchaseOrder) {
        return salesOrderMapper.updateByPrimaryKey(purchaseOrder);
    }

    @Override
    public int delete(SalesOrder purchaseOrder) {
        return salesOrderMapper.deleteByPrimaryKey(purchaseOrder);
    }

    /**
     * 获得唯一的进货单号
     * @return
     */
    public String getSalesOrderNumber(){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
        String time=sdf.format(new Date());
        String randomString = RandomStringUtils.randomNumeric(8);
        return "S"+time+randomString;
    }

    /**
     * 审核
     * @param order
     * @return
     */
    public int check(SalesOrder order) {
        return salesOrderMapper.updateCheckState(order);
    }
}
