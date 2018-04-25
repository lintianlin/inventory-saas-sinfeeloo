package com.sinfeeloo.inventory.entity;

import java.util.Date;

public class User {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lz_sys_user.id
     *
     * @mbggenerated Wed Apr 25 17:12:01 CST 2018
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lz_sys_user.account
     *
     * @mbggenerated Wed Apr 25 17:12:01 CST 2018
     */
    private String account;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lz_sys_user.password
     *
     * @mbggenerated Wed Apr 25 17:12:01 CST 2018
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lz_sys_user.roleId
     *
     * @mbggenerated Wed Apr 25 17:12:01 CST 2018
     */
    private Integer roleid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lz_sys_user.roleName
     *
     * @mbggenerated Wed Apr 25 17:12:01 CST 2018
     */
    private String rolename;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lz_sys_user.employeeId
     *
     * @mbggenerated Wed Apr 25 17:12:01 CST 2018
     */
    private Integer employeeid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lz_sys_user.updater
     *
     * @mbggenerated Wed Apr 25 17:12:01 CST 2018
     */
    private String updater;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lz_sys_user.updatime
     *
     * @mbggenerated Wed Apr 25 17:12:01 CST 2018
     */
    private Date updatime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lz_sys_user.state
     *
     * @mbggenerated Wed Apr 25 17:12:01 CST 2018
     */
    private Integer state;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lz_sys_user.isLocked
     *
     * @mbggenerated Wed Apr 25 17:12:01 CST 2018
     */
    private Integer islocked;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lz_sys_user.lockTime
     *
     * @mbggenerated Wed Apr 25 17:12:01 CST 2018
     */
    private Date locktime;

    private String token;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lz_sys_user.id
     *
     * @return the value of lz_sys_user.id
     *
     * @mbggenerated Wed Apr 25 17:12:01 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lz_sys_user.id
     *
     * @param id the value for lz_sys_user.id
     *
     * @mbggenerated Wed Apr 25 17:12:01 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lz_sys_user.account
     *
     * @return the value of lz_sys_user.account
     *
     * @mbggenerated Wed Apr 25 17:12:01 CST 2018
     */
    public String getAccount() {
        return account;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lz_sys_user.account
     *
     * @param account the value for lz_sys_user.account
     *
     * @mbggenerated Wed Apr 25 17:12:01 CST 2018
     */
    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lz_sys_user.password
     *
     * @return the value of lz_sys_user.password
     *
     * @mbggenerated Wed Apr 25 17:12:01 CST 2018
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lz_sys_user.password
     *
     * @param password the value for lz_sys_user.password
     *
     * @mbggenerated Wed Apr 25 17:12:01 CST 2018
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lz_sys_user.roleId
     *
     * @return the value of lz_sys_user.roleId
     *
     * @mbggenerated Wed Apr 25 17:12:01 CST 2018
     */
    public Integer getRoleid() {
        return roleid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lz_sys_user.roleId
     *
     * @param roleid the value for lz_sys_user.roleId
     *
     * @mbggenerated Wed Apr 25 17:12:01 CST 2018
     */
    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lz_sys_user.roleName
     *
     * @return the value of lz_sys_user.roleName
     *
     * @mbggenerated Wed Apr 25 17:12:01 CST 2018
     */
    public String getRolename() {
        return rolename;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lz_sys_user.roleName
     *
     * @param rolename the value for lz_sys_user.roleName
     *
     * @mbggenerated Wed Apr 25 17:12:01 CST 2018
     */
    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lz_sys_user.employeeId
     *
     * @return the value of lz_sys_user.employeeId
     *
     * @mbggenerated Wed Apr 25 17:12:01 CST 2018
     */
    public Integer getEmployeeid() {
        return employeeid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lz_sys_user.employeeId
     *
     * @param employeeid the value for lz_sys_user.employeeId
     *
     * @mbggenerated Wed Apr 25 17:12:01 CST 2018
     */
    public void setEmployeeid(Integer employeeid) {
        this.employeeid = employeeid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lz_sys_user.updater
     *
     * @return the value of lz_sys_user.updater
     *
     * @mbggenerated Wed Apr 25 17:12:01 CST 2018
     */
    public String getUpdater() {
        return updater;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lz_sys_user.updater
     *
     * @param updater the value for lz_sys_user.updater
     *
     * @mbggenerated Wed Apr 25 17:12:01 CST 2018
     */
    public void setUpdater(String updater) {
        this.updater = updater == null ? null : updater.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lz_sys_user.updatime
     *
     * @return the value of lz_sys_user.updatime
     *
     * @mbggenerated Wed Apr 25 17:12:01 CST 2018
     */
    public Date getUpdatime() {
        return updatime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lz_sys_user.updatime
     *
     * @param updatime the value for lz_sys_user.updatime
     *
     * @mbggenerated Wed Apr 25 17:12:01 CST 2018
     */
    public void setUpdatime(Date updatime) {
        this.updatime = updatime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lz_sys_user.state
     *
     * @return the value of lz_sys_user.state
     *
     * @mbggenerated Wed Apr 25 17:12:01 CST 2018
     */
    public Integer getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lz_sys_user.state
     *
     * @param state the value for lz_sys_user.state
     *
     * @mbggenerated Wed Apr 25 17:12:01 CST 2018
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lz_sys_user.isLocked
     *
     * @return the value of lz_sys_user.isLocked
     *
     * @mbggenerated Wed Apr 25 17:12:01 CST 2018
     */
    public Integer getIslocked() {
        return islocked;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lz_sys_user.isLocked
     *
     * @param islocked the value for lz_sys_user.isLocked
     *
     * @mbggenerated Wed Apr 25 17:12:01 CST 2018
     */
    public void setIslocked(Integer islocked) {
        this.islocked = islocked;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lz_sys_user.lockTime
     *
     * @return the value of lz_sys_user.lockTime
     *
     * @mbggenerated Wed Apr 25 17:12:01 CST 2018
     */
    public Date getLocktime() {
        return locktime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lz_sys_user.lockTime
     *
     * @param locktime the value for lz_sys_user.lockTime
     *
     * @mbggenerated Wed Apr 25 17:12:01 CST 2018
     */
    public void setLocktime(Date locktime) {
        this.locktime = locktime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}