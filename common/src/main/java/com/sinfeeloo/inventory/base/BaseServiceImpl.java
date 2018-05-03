package com.sinfeeloo.inventory.base;

import com.sinfeeloo.inventory.entity.Paging;

import java.util.List;
import java.util.Map;

/**
 * @Author: mhj
 * @Desc:
 * @Date: 2018/5/3 11:07
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {

    /**
     * 分页方法二次加工
     * @param paging
     */
    @Override
    public void getListByPage(Paging<T> paging) {
        paging.setTotal(selectListCount(paging.getSearchMap()));
        paging.setList(selectListByPage(paging.getSearchMap()));

    }

    protected abstract List<T> selectListByPage(Map<String, Object> searchMap);

    protected abstract long selectListCount(Map<String, Object> searchMap);


}
