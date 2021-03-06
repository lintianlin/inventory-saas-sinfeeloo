package com.sinfeeloo.inventory.mapper;

import com.sinfeeloo.inventory.entity.PurchaseOrder;
import java.util.List;
import java.util.Map;

public interface PurchaseOrderMapper {


    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lz_purchase_order
     *
     * @mbggenerated Thu May 03 10:36:58 CST 2018
     */
    int insert(PurchaseOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lz_purchase_order
     *
     * @mbggenerated Thu May 03 10:36:58 CST 2018
     */
    PurchaseOrder selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lz_purchase_order
     *
     * @mbggenerated Thu May 03 10:36:58 CST 2018
     */
    List<PurchaseOrder> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lz_purchase_order
     *
     * @mbggenerated Thu May 03 10:36:58 CST 2018
     */
    int updateByPrimaryKey(PurchaseOrder record);

    List<PurchaseOrder> selectOrderListByPage(Map<String, Object> searchMap);

    long selectOrderListCount(Map<String, Object> searchMap);


    /**
     * 采购单审核列表
     * @param searchMap
     * @return
     */
    List<PurchaseOrder> selectCheckOrderListByPage(Map<String, Object> searchMap);

    /**
     * 采购单审核列表数量
     * @param searchMap
     * @return
     */
    long selectCheckOrderListCount(Map<String, Object> searchMap);


    /**
     * 删除
     * @param purchaseOrder
     * @return
     */
    int deleteByPrimaryKey(PurchaseOrder purchaseOrder);

    /**
     * 审核
     * @param order
     * @return
     */
    int updateCheckState(PurchaseOrder order);



}