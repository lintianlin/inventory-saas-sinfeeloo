package com.sinfeeloo.inventory.service;

import com.sinfeeloo.inventory.base.BaseServiceImpl;
import com.sinfeeloo.inventory.entity.Supplier;
import com.sinfeeloo.inventory.mapper.SupplierMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: mhj
 * @Desc:
 * @Date: 2018/5/3 11:05
 */
@Service
public class SupplierService extends BaseServiceImpl<Supplier> {

    @Autowired
    private SupplierMapper supplierMapper;

    @Override
    public void add(Supplier supplier) {
        supplierMapper.insert(supplier);
    }

    @Override
    protected List<Supplier> selectListByPage(Map<String, Object> searchMap) {
        return supplierMapper.selectSupperListByPage(searchMap);
    }

    @Override
    protected long selectListCount(Map<String, Object> searchMap) {
        return supplierMapper.selectSupperListCount(searchMap);
    }

    @Override
    public int update(Supplier supplier) {
        return supplierMapper.updateByPrimaryKey(supplier);
    }

    @Override
    public int delete(Supplier supplier) {
        return supplierMapper.deleteByPrimaryKey(supplier);
    }
}
