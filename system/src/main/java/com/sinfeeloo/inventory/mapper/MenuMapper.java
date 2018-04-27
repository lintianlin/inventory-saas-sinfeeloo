package com.sinfeeloo.inventory.mapper;

import com.sinfeeloo.inventory.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuMapper {


    /**
     * 添加
     *
     * @mbggenerated Wed Apr 25 17:12:01 CST 2018
     */
    int insert(Menu record);

    /**
     * 查询
     *
     * @mbggenerated Wed Apr 25 17:12:01 CST 2018
     */
    Menu selectByPrimaryKey(Integer id);

    /**
     * 查询
     *
     * @mbggenerated Wed Apr 25 17:12:01 CST 2018
     */
    List<Menu> selectAll();

    /**
     * 修改
     *
     * @mbggenerated Wed Apr 25 17:12:01 CST 2018
     */
    int updateByPrimaryKey(Menu record);


    /**
     * 删除
     *
     * @mbggenerated Wed Apr 25 17:12:01 CST 2018
     */
    int deleteByPrimaryKey(Menu record);

    /**
     * 通过名称查询菜单
     *
     * @param name
     * @return
     */
    List<Menu> selectByNameOrPath(@Param(value = "name") String name, @Param(value = "path") String path);


    /**
     * 查询根节点下面所有的子节点
     * @param upid
     * @return
     */
    List<Menu> selectByUpId(Integer upid);
}