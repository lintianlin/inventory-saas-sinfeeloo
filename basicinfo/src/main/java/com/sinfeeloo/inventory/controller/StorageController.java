package com.sinfeeloo.inventory.controller;

import com.sinfeeloo.inventory.base.BaseController;
import com.sinfeeloo.inventory.entity.ComResp;
import com.sinfeeloo.inventory.entity.Paging;
import com.sinfeeloo.inventory.entity.Storage;
import com.sinfeeloo.inventory.entity.User;
import com.sinfeeloo.inventory.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: mhj
 * @Desc:
 * @Date: 2018/5/2 13:44
 */

@RestController
@RequestMapping(value = "/storage")
public class StorageController extends BaseController {

    @Autowired
    private StorageService storageService;


    /**
     * 添加库存
     *
     * @param storageName
     * @param storageCode
     * @param storageAddress
     * @param desc
     * @param administratorId
     * @param updater
     * @return
     */
    @PostMapping(value = "/addStorage")
    public ComResp addStorage(@RequestParam(value = "storageName") String storageName,
                              @RequestParam(value = "storageCode") String storageCode,
                              @RequestParam(value = "storageAddress") String storageAddress,
                              @RequestParam(value = "desc") String desc,
                              @RequestParam(value = "administratorId") Integer administratorId,
                              @RequestParam(value = "updater") String updater) {

        try {
            Storage storage = new Storage();
            storage.setName(storageName);
            storage.setCode(storageCode);
            storage.setAddress(storageAddress);
            storage.setDescs(desc);
            storage.setAdminid(administratorId);
            storage.setUpdater(updater);
            storage.setState(1);
            storageService.addStorage(storage);
            return ComResp.success("添加成功！");
        } catch (Exception e) {
            return ComResp.error("添加失败！", e);
        }
    }


    /**
     * 仓库分页查询
     *
     * @param storageName
     * @param limit
     * @param page
     * @param sortCode
     * @param sortRole
     * @return
     */
    @GetMapping(value = "/getStorageListByPage")
    public ComResp getStorageListByPage(@RequestParam(value = "storageName") String storageName,
                                        @RequestParam(value = "limit", required = false, defaultValue = "20") Integer limit,
                                        @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                        @RequestParam(value = "sortCode", required = false, defaultValue = "id") String sortCode,
                                        @RequestParam(value = "sortRole", required = false, defaultValue = "ASC") String sortRole) {

        Paging<Storage> paging = new Paging<>(page, limit);

        try {
            paging.putSearch("storageName", storageName);
            paging.putSearch("limit", limit);
            paging.putSearch("page", page);
            paging.putSearch("sortCode", sortCode);
            paging.putSearch("sortRole", sortRole);
            storageService.getStorageListByPage(paging);
            return ComResp.success("查询成功！", paging);
        } catch (Exception e) {
            return ComResp.error("查询失败！", e);
        }

    }


    /**
     * 修改仓库
     * @param storageId
     * @param storageName
     * @param storageCode
     * @param storageAddress
     * @param desc
     * @param administratorId
     * @param updater
     * @return
     */
    @PostMapping(value = "/modifyStorage")
    public ComResp modifyStorage(@RequestParam(value = "storageId") Integer storageId,
                                 @RequestParam(value = "storageName") String storageName,
                                 @RequestParam(value = "storageCode") String storageCode,
                                 @RequestParam(value = "storageAddress") String storageAddress,
                                 @RequestParam(value = "desc") String desc,
                                 @RequestParam(value = "administratorId") Integer administratorId,
                                 @RequestParam(value = "updater") String updater) {

        try {
            Storage storage = new Storage();
            storage.setId(storageId);
            storage.setName(storageName);
            storage.setCode(storageCode);
            storage.setAddress(storageAddress);
            storage.setDescs(desc);
            storage.setAdminid(administratorId);
            storage.setUpdater(updater);
            int num = storageService.modifyStorage(storage);
            return num > 0 ? ComResp.success("修改成功！") : ComResp.error("修改失败！");
        } catch (Exception e) {
            return ComResp.error("修改失败！", e);
        }
    }


    /**
     * 删除仓库
     * @param storageId
     * @return
     */
    @PostMapping(value = "/deleteStorage")
    public ComResp deleteStorage(@RequestParam(value = "id") Integer storageId,
                                 @RequestAttribute User user) {
        try {
            storageService.deleteStorage(storageId, user.getEmployeeName());
            return ComResp.success("删除成功！");
        } catch (Exception e) {
            return ComResp.error("删除失败！", e);
        }
    }

}
