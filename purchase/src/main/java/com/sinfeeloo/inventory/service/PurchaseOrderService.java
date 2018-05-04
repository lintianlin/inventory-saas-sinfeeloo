package com.sinfeeloo.inventory.service;

import com.sinfeeloo.inventory.base.BaseServiceImpl;
import com.sinfeeloo.inventory.entity.Paging;
import com.sinfeeloo.inventory.entity.PurchaseOrder;
import com.sinfeeloo.inventory.mapper.PurchaseOrderMapper;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author: mhj
 * @Desc:
 * @Date: 2018/5/3 13:21
 */
@Service
public class PurchaseOrderService extends BaseServiceImpl<PurchaseOrder> {

    @Autowired
    private PurchaseOrderMapper purchaseOrderMapper;

    @Override
    protected List<PurchaseOrder> selectListByPage(Map<String, Object> searchMap) {
        return purchaseOrderMapper.selectOrderListByPage(searchMap);
    }

    @Override
    protected long selectListCount(Map<String, Object> searchMap) {
        return purchaseOrderMapper.selectOrderListCount(searchMap);
    }

    @Override
    public void add(PurchaseOrder purchaseOrder) {
        purchaseOrderMapper.insert(purchaseOrder);
    }

    @Override
    public int update(PurchaseOrder purchaseOrder) {
        return purchaseOrderMapper.updateByPrimaryKey(purchaseOrder);
    }

    @Override
    public int delete(PurchaseOrder purchaseOrder) {
        return purchaseOrderMapper.deleteByPrimaryKey(purchaseOrder);
    }

    /**
     * 获得唯一的进货单号
     *
     * @return
     */
    public String getPurchaseOrderNumber() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String time = sdf.format(new Date());
        String randomString = RandomStringUtils.randomNumeric(8);
        return "P" + time + randomString;
    }

    /**
     * 审核
     *
     * @param order
     * @return
     */
    public int check(PurchaseOrder order) {
        return purchaseOrderMapper.updateCheckState(order);
    }


    /**
     * 分采购单审核列表分页
     *
     * @param paging
     */
    public void getCheckListByPage(Paging<PurchaseOrder> paging) {
        paging.setTotal(purchaseOrderMapper.selectCheckOrderListCount(paging.getSearchMap()));
        paging.setList(purchaseOrderMapper.selectCheckOrderListByPage(paging.getSearchMap()));

    }
}
