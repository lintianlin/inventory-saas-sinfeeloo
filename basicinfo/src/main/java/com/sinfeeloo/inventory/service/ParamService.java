package com.sinfeeloo.inventory.service;

import com.sinfeeloo.inventory.entity.Paging;
import com.sinfeeloo.inventory.entity.Param;
import com.sinfeeloo.inventory.mapper.ParamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: mhj
 * @Desc:基础参数管理
 * @Date: 2018/5/2 17:30
 */
@Service
public class ParamService {


    @Autowired
    private ParamMapper paramMapper;


    /**
     * 添加参数
     *
     * @param param
     */
    public void addParam(Param param) {
        paramMapper.insert(param);
    }

    public void getParamListByPage(Paging<Param> paging) {
        paging.setTotal(paramMapper.selectParamListCount(paging.getSearchMap()));
        paging.setList(paramMapper.selectParamListByPage(paging.getSearchMap()));
    }

    /**
     * 修改
     *
     * @param param
     * @return
     */
    public int modifyParam(Param param) {
        return paramMapper.updateByPrimaryKey(param);
    }

    /**
     * 删除
     *
     * @param id
     * @param updater
     */
    public void deleteParam(Integer id, String updater) {
        Param param = new Param();
        param.setId(id);
        param.setUpdater(updater);
        paramMapper.deleteByPrimaryKey(param);
    }

    /**
     * 获取参数类型
     * @return
     */
    public List<Param> getParamTypeList(){
        return paramMapper.selectParamType();
    }
}
