package com.sinfeeloo.inventory.mapper;

import com.sinfeeloo.inventory.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lz_sys_user
     *
     * @mbggenerated Wed Apr 25 17:12:01 CST 2018
     */
    User selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lz_sys_user
     *
     * @mbggenerated Wed Apr 25 17:12:01 CST 2018
     */
    List<User> selectAll();


    //==========================自定义开始======================================

    /**
     * 通过账号查询账户
     *
     * @param account
     * @return
     */
    User selectByAccount(String account);

    /**
     * 添加用户
     *
     * @mbggenerated Wed Apr 25 17:12:01 CST 2018
     */
    int insert(User record);

    /**
     * 分页总数量
     *
     * @param searchMap
     * @return
     */
    long selectUserCount(Map<String, Object> searchMap);

    /**
     * 分页列表
     *
     * @param searchMap
     * @return
     */
    List<User> selectUserListByPage(Map<String, Object> searchMap);

    /**
     * 修改
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(User record);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 锁定
     *
     * @param id
     * @return
     */
    int lockByPrimaryKey(@Param(value = "id") Integer id, @Param(value = "isLocked") Integer isLocked);

    /**
     * 修改密码
     *
     * @param id
     * @param newPwd
     * @return
     */
    int updatePassword(@Param(value = "id") Integer id, @Param(value = "newPwd") String newPwd);

    /**
     * 通过id找到user对象对应的菜单
     * @param id
     * @return
     */
    User selectMenusByPrimaryKey(Integer id);

    //==========================自定义结束======================================
}