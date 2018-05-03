package com.sinfeeloo.inventory.base;

import com.sinfeeloo.inventory.entity.Paging;

/**
 * @Author: mhj
 * @Desc: service 基类
 * @Date: 2018/5/3 10:58
 */
public interface BaseService<T> {
    /**
     * 添加
     *
     * @param t
     */
    void add(T t);

    /**
     * 获取分页列表
     *
     * @param paging
     */
    void getListByPage(Paging<T> paging);

    /**
     * 修改
     *
     * @param t
     */
    int update(T t);

    /**
     * 删除
     *
     * @param t
     */
    int delete(T t);
}
