package com.sinfeeloo.inventory.controller;

import com.sinfeeloo.inventory.entity.ComResp;
import com.sinfeeloo.inventory.entity.Paging;
import com.sinfeeloo.inventory.entity.Param;
import com.sinfeeloo.inventory.entity.User;
import com.sinfeeloo.inventory.service.ParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: mhj
 * @Desc:参数管理
 * @Date: 2018/5/2 17:31
 */
@RestController
@RequestMapping(value = "/param")
public class ParamController {


    @Autowired
    private ParamService paramService;

    /**
     * 添加参数
     *
     * @param name
     * @param desc
     * @return
     */
    @PostMapping(value = "/addParam")
    public ComResp addParam(@RequestParam(value = "typeName") String typeName,
                            @RequestParam(value = "typeId") Integer typeId,
                            @RequestParam(value = "name") String name,
                            @RequestParam(value = "desc") String desc,
                            @RequestAttribute User user) {

        try {
            Param param = new Param();
            param.setTypename(typeName);
            param.setTypeid(typeId);
            param.setName(name);
            param.setDescs(desc);
            param.setCreater(user.getEmployeeName());
            param.setState(1);
            paramService.addParam(param);
            return ComResp.success("添加成功！");
        } catch (Exception e) {
            return ComResp.error("添加失败！", e);
        }

    }


    /**
     * 分页查询参数
     *
     * @param name
     * @param typeName
     * @param limit
     * @param page
     * @param sortCode
     * @param sortRole
     * @return
     */
    @GetMapping(value = "/getParamListByPage")
    public ComResp getParamListByPage(@RequestParam(value = "name", required = false) String name,
                                      @RequestParam(value = "typeName", required = false) String typeName,
                                      @RequestParam(value = "typeId", required = false) Integer typeId,
                                      @RequestParam(value = "limit", required = false, defaultValue = "20") Integer limit,
                                      @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                      @RequestParam(value = "sortCode", required = false, defaultValue = "id") String sortCode,
                                      @RequestParam(value = "sortRole", required = false, defaultValue = "ASC") String sortRole) {

        Paging<Param> paging = new Paging<>(page, limit);

        try {
            paging.putSearch("name", name);
            paging.putSearch("typename", typeName);
            paging.putSearch("typeid", typeId);
            paging.putSearch("limit", limit);
            paging.putSearch("page", page);
            paging.putSearch("sortCode", sortCode);
            paging.putSearch("sortRole", sortRole);
            paramService.getParamListByPage(paging);
            return ComResp.success("查询成功！", paging);
        } catch (Exception e) {
            return ComResp.error("查询失败！", e);
        }

    }


    /**
     * 修改参数
     *
     * @param id
     * @param name
     * @param desc
     * @return
     */
    @PostMapping(value = "/modifyParam")
    public ComResp modifyParam(@RequestParam(value = "id") Integer id,
                               @RequestParam(value = "typeName") String typeName,
                               @RequestParam(value = "typeId") Integer typeId,
                               @RequestParam(value = "name") String name,
                               @RequestParam(value = "desc") String desc,
                               @RequestAttribute User user) {

        try {
            Param param = new Param();
            param.setId(id);
            param.setTypename(typeName);
            param.setTypeid(typeId);
            param.setName(name);
            param.setDescs(desc);
            param.setUpdater(user.getEmployeeName());
            int num = paramService.modifyParam(param);
            return num > 0 ? ComResp.success("修改成功！") : ComResp.error("修改失败！");
        } catch (Exception e) {
            return ComResp.error("修改失败！", e);
        }

    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @PostMapping(value = "/deleteParam")
    public ComResp deleteParam(@RequestParam(value = "id") Integer id,
                               @RequestAttribute User user) {

        try {
            paramService.deleteParam(id, user.getEmployeeName());
            return ComResp.success("删除成功！");
        } catch (Exception e) {
            return ComResp.error("删除失败！", e);
        }

    }

    /**
     * 删除
     *
     * @return
     */
    @GetMapping(value = "/getParamTypeList")
    public ComResp getParamTypeList() {
        try {
            List<Param> paramTypeList = paramService.getParamTypeList();
            return ComResp.success("查询成功！", paramTypeList);
        } catch (Exception e) {
            return ComResp.error("查询失败！", e);
        }

    }

}
