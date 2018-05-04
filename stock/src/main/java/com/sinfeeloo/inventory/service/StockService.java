package com.sinfeeloo.inventory.service;

import com.sinfeeloo.inventory.base.BaseServiceImpl;
import com.sinfeeloo.inventory.entity.PurchaseOrder;
import com.sinfeeloo.inventory.entity.SalesOrder;
import com.sinfeeloo.inventory.entity.Stock;
import com.sinfeeloo.inventory.mapper.PurchaseOrderMapper;
import com.sinfeeloo.inventory.mapper.SalesOrderMapper;
import com.sinfeeloo.inventory.mapper.StockMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @Author: mhj
 * @Desc:库存管理
 * @Date: 2018/5/4 10:26
 */
@Service
public class StockService extends BaseServiceImpl<Stock> {

    @Autowired
    private StockMapper stockMapper;

    @Autowired
    private PurchaseOrderMapper purchaseOrderMapper;

    @Autowired
    private SalesOrderMapper salesOrderMapper;

    @Override
    protected List<Stock> selectListByPage(Map<String, Object> searchMap) {
        return null;
    }

    @Override
    protected long selectListCount(Map<String, Object> searchMap) {
        return 0;
    }

    @Override
    public void add(Stock stock) {
        stockMapper.insert(stock);
    }

    @Override
    public int update(Stock stock) {
        return 0;
    }

    @Override
    public int delete(Stock stock) {
        return 0;
    }


    /**
     * 审核采购单
     *
     * @param order
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public int checkPurchaseOrder(PurchaseOrder order) {
        //通过id查询出这个订单
        PurchaseOrder purchaseOrder = purchaseOrderMapper.selectByPrimaryKey(order.getId());
        //查询一个这个仓库中是否有这个商品
        Stock tempStock = stockMapper.selectByGoodsIdAndRepoId(purchaseOrder.getGoodsid(), purchaseOrder.getRepoid());
        if (null != tempStock) {//如果这个仓库中有这个商品
            //总数量修改
            tempStock.setTotalcount(tempStock.getTotalcount() + purchaseOrder.getCount());
            //进价修改
            tempStock.setBuyprice(purchaseOrder.getUnitprice());
            //平均进价修改
//                tempStock.setAvgbuyprice();
            //库存总值修改
            tempStock.setTotalbuyprice(tempStock.getTotalbuyprice().add(purchaseOrder.getTotalprice()));
            int num = stockMapper.updateByPrimaryKey(tempStock);
            if (num > 0) {//更新库存表成功
                return purchaseOrderMapper.updateCheckState(order);
            } else {//更新库存表失败
                return 0;
            }
        } else {//如果这个仓库中没有这个商品
            Stock stock = new Stock();
            stock.setGoodsid(purchaseOrder.getGoodsid());
            stock.setRepoid(purchaseOrder.getRepoid());
            stock.setTotalcount(purchaseOrder.getCount());
            stock.setBuyprice(purchaseOrder.getUnitprice());
            stock.setTotalbuyprice(purchaseOrder.getTotalprice());
            stock.setAvgbuyprice(purchaseOrder.getUnitprice());
            stock.setState(1);
            int num =stockMapper.insert(stock);
            //更新订单表
            if (num > 0) {//更新库存表成功
                return purchaseOrderMapper.updateCheckState(order);
            } else {//更新库存表失败
                return 0;
            }
        }
    }


    /**
     * 审核销售单
     *
     * @param order
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public int checkSalesOrder(SalesOrder order) {
        //通过id查询出这个订单
        SalesOrder salesOrder = salesOrderMapper.selectByPrimaryKey(order.getId());
        //查询一个这个仓库中是否有这个商品
        Stock tempStock = stockMapper.selectByGoodsIdAndRepoId(salesOrder.getGoodsid(), salesOrder.getRepoid());
        if (null != tempStock) {//如果这个仓库中有这个商品
            if (tempStock.getTotalcount() > salesOrder.getCount()) {//库存充足
                //总数量修改
                tempStock.setTotalcount(tempStock.getTotalcount() - salesOrder.getCount());
                //进价修改
                tempStock.setBuyprice(salesOrder.getUnitprice());
                //平均进价修改
//                tempStock.setAvgbuyprice();
                //库存总值修改
                tempStock.setTotalbuyprice(tempStock.getTotalbuyprice().subtract(salesOrder.getTotalprice()));
                int num = stockMapper.updateByPrimaryKey(tempStock);
                if (num > 0) {//修改成功
                    //更新订单中审核状态
                    return salesOrderMapper.updateCheckState(order);
                } else {//修改失败
                    return 0;
                }
            } else {//库存不足
                return -1;
            }
        } else {//如果这个仓库中没有这个商品
            return -1;
        }
    }
}
