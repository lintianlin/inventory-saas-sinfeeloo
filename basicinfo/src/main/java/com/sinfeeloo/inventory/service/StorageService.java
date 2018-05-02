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


    /**
     * 添加
     * @param storage
     */
    public void addStorage(Storage storage) {
        storageMapper.insert(storage);
    }

    /**
     * 分页
     * @param paging
     */
    public void getStorageListByPage(Paging<Storage> paging) {
        paging.setTotal(storageMapper.selectStorageCount(paging.getSearchMap()));
        paging.setList(storageMapper.selectStorageListByPage(paging.getSearchMap()));
    }

    /**
     * 修改
     * @param storage
     * @return
     */
    public int modifyStorage(Storage storage) {
        return storageMapper.updateByPrimaryKey(storage);
    }

    /**
     * 删除
     * @param id
     * @param updater
     */
    public void deleteStorage(Integer id, String updater) {
        Storage storage = new Storage();
        storage.setId(id);
        storage.setUpdater(updater);
        storageMapper.deleteByPrimaryKey(storage);
    }
}
