package com.sinfeeloo.inventory.service;

import com.sinfeeloo.inventory.entity.Paging;
import com.sinfeeloo.inventory.entity.Storage;
import com.sinfeeloo.inventory.mapper.StorageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: mhj
 * @Desc: 仓库管理
 * @Date: 2018/5/2 13:42
 */
@Service
public class StorageService {

    @Autowired
    private StorageMapper storageMapper;


    public void addStorage(Storage storage) {
        storageMapper.insert(storage);
    }

    public void getStorageListByPage(Paging<Storage> paging) {
        paging.setTotal(storageMapper.selectStorageCount(paging.getSearchMap()));
        paging.setList(storageMapper.selectStorageListByPage(paging.getSearchMap()));
    }
}
