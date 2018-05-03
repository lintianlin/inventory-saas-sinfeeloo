package com.sinfeeloo.inventory.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lz_purchase_order.id
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lz_purchase_order.goodsId
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    private Integer goodsid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lz_purchase_order.supplierId
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    private Integer supplierid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lz_purchase_order.supplierName
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    private String suppliername;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lz_purchase_order.repoId
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    private Integer repoid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lz_purchase_order.orderNumber
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    private String ordernumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lz_purchase_order.count
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    private Integer count;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lz_purchase_order.unitPrice
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    private BigDecimal unitprice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lz_purchase_order.totalPrice
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    private BigDecimal totalprice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lz_purchase_order.employeeId
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    private Integer employeeid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lz_purchase_order.descs
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    private String descs;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lz_purchase_order.checkState
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    private Integer checkstate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lz_purchase_order.checkResult
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    private String checkresult;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lz_purchase_order.checkAccount
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    private String checkaccount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lz_purchase_order.checktime
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    private Date checktime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lz_purchase_order.taketime
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    private Date taketime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lz_purchase_order.creater
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    private String creater;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lz_purchase_order.creatime
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    private Date creatime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lz_purchase_order.updater
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    private String updater;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lz_purchase_order.updatime
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    private Date updatime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lz_purchase_order.state
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    private Integer state;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lz_purchase_order.type
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    private Integer type;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lz_purchase_order.id
     *
     * @return the value of lz_purchase_order.id
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lz_purchase_order.id
     *
     * @param id the value for lz_purchase_order.id
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lz_purchase_order.goodsId
     *
     * @return the value of lz_purchase_order.goodsId
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    public Integer getGoodsid() {
        return goodsid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lz_purchase_order.goodsId
     *
     * @param goodsid the value for lz_purchase_order.goodsId
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lz_purchase_order.supplierId
     *
     * @return the value of lz_purchase_order.supplierId
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    public Integer getSupplierid() {
        return supplierid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lz_purchase_order.supplierId
     *
     * @param supplierid the value for lz_purchase_order.supplierId
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    public void setSupplierid(Integer supplierid) {
        this.supplierid = supplierid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lz_purchase_order.supplierName
     *
     * @return the value of lz_purchase_order.supplierName
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    public String getSuppliername() {
        return suppliername;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lz_purchase_order.supplierName
     *
     * @param suppliername the value for lz_purchase_order.supplierName
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    public void setSuppliername(String suppliername) {
        this.suppliername = suppliername == null ? null : suppliername.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lz_purchase_order.repoId
     *
     * @return the value of lz_purchase_order.repoId
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    public Integer getRepoid() {
        return repoid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lz_purchase_order.repoId
     *
     * @param repoid the value for lz_purchase_order.repoId
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    public void setRepoid(Integer repoid) {
        this.repoid = repoid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lz_purchase_order.orderNumber
     *
     * @return the value of lz_purchase_order.orderNumber
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    public String getOrdernumber() {
        return ordernumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lz_purchase_order.orderNumber
     *
     * @param ordernumber the value for lz_purchase_order.orderNumber
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    public void setOrdernumber(String ordernumber) {
        this.ordernumber = ordernumber == null ? null : ordernumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lz_purchase_order.count
     *
     * @return the value of lz_purchase_order.count
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    public Integer getCount() {
        return count;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lz_purchase_order.count
     *
     * @param count the value for lz_purchase_order.count
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lz_purchase_order.unitPrice
     *
     * @return the value of lz_purchase_order.unitPrice
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    public BigDecimal getUnitprice() {
        return unitprice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lz_purchase_order.unitPrice
     *
     * @param unitprice the value for lz_purchase_order.unitPrice
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    public void setUnitprice(BigDecimal unitprice) {
        this.unitprice = unitprice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lz_purchase_order.totalPrice
     *
     * @return the value of lz_purchase_order.totalPrice
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    public BigDecimal getTotalprice() {
        return totalprice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lz_purchase_order.totalPrice
     *
     * @param totalprice the value for lz_purchase_order.totalPrice
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    public void setTotalprice(BigDecimal totalprice) {
        this.totalprice = totalprice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lz_purchase_order.employeeId
     *
     * @return the value of lz_purchase_order.employeeId
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    public Integer getEmployeeid() {
        return employeeid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lz_purchase_order.employeeId
     *
     * @param employeeid the value for lz_purchase_order.employeeId
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    public void setEmployeeid(Integer employeeid) {
        this.employeeid = employeeid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lz_purchase_order.descs
     *
     * @return the value of lz_purchase_order.descs
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    public String getDescs() {
        return descs;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lz_purchase_order.descs
     *
     * @param descs the value for lz_purchase_order.descs
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    public void setDescs(String descs) {
        this.descs = descs == null ? null : descs.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lz_purchase_order.checkState
     *
     * @return the value of lz_purchase_order.checkState
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    public Integer getCheckstate() {
        return checkstate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lz_purchase_order.checkState
     *
     * @param checkstate the value for lz_purchase_order.checkState
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    public void setCheckstate(Integer checkstate) {
        this.checkstate = checkstate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lz_purchase_order.checkResult
     *
     * @return the value of lz_purchase_order.checkResult
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    public String getCheckresult() {
        return checkresult;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lz_purchase_order.checkResult
     *
     * @param checkresult the value for lz_purchase_order.checkResult
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    public void setCheckresult(String checkresult) {
        this.checkresult = checkresult == null ? null : checkresult.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lz_purchase_order.checkAccount
     *
     * @return the value of lz_purchase_order.checkAccount
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    public String getCheckaccount() {
        return checkaccount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lz_purchase_order.checkAccount
     *
     * @param checkaccount the value for lz_purchase_order.checkAccount
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    public void setCheckaccount(String checkaccount) {
        this.checkaccount = checkaccount == null ? null : checkaccount.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lz_purchase_order.checktime
     *
     * @return the value of lz_purchase_order.checktime
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    public Date getChecktime() {
        return checktime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lz_purchase_order.checktime
     *
     * @param checktime the value for lz_purchase_order.checktime
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    public void setChecktime(Date checktime) {
        this.checktime = checktime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lz_purchase_order.taketime
     *
     * @return the value of lz_purchase_order.taketime
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    public Date getTaketime() {
        return taketime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lz_purchase_order.taketime
     *
     * @param taketime the value for lz_purchase_order.taketime
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    public void setTaketime(Date taketime) {
        this.taketime = taketime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lz_purchase_order.creater
     *
     * @return the value of lz_purchase_order.creater
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    public String getCreater() {
        return creater;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lz_purchase_order.creater
     *
     * @param creater the value for lz_purchase_order.creater
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lz_purchase_order.creatime
     *
     * @return the value of lz_purchase_order.creatime
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    public Date getCreatime() {
        return creatime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lz_purchase_order.creatime
     *
     * @param creatime the value for lz_purchase_order.creatime
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    public void setCreatime(Date creatime) {
        this.creatime = creatime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lz_purchase_order.updater
     *
     * @return the value of lz_purchase_order.updater
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    public String getUpdater() {
        return updater;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lz_purchase_order.updater
     *
     * @param updater the value for lz_purchase_order.updater
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    public void setUpdater(String updater) {
        this.updater = updater == null ? null : updater.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lz_purchase_order.updatime
     *
     * @return the value of lz_purchase_order.updatime
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    public Date getUpdatime() {
        return updatime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lz_purchase_order.updatime
     *
     * @param updatime the value for lz_purchase_order.updatime
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    public void setUpdatime(Date updatime) {
        this.updatime = updatime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lz_purchase_order.state
     *
     * @return the value of lz_purchase_order.state
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    public Integer getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lz_purchase_order.state
     *
     * @param state the value for lz_purchase_order.state
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lz_purchase_order.type
     *
     * @return the value of lz_purchase_order.type
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lz_purchase_order.type
     *
     * @param type the value for lz_purchase_order.type
     *
     * @mbggenerated Thu May 03 10:29:31 CST 2018
     */
    public void setType(Integer type) {
        this.type = type;
    }
}