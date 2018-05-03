package com.sinfeeloo.inventory.controller;

import com.sinfeeloo.inventory.entity.ComResp;
import com.sinfeeloo.inventory.entity.Paging;
import com.sinfeeloo.inventory.entity.Param;
import com.sinfeeloo.inventory.service.ParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: mhj
 * @Desc:
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
     * @param type
     * @param name
     * @param desc
     * @param creater
     * @return
     */
    @PostMapping(value = "/addParam")
    public ComResp addParam(@RequestParam(value = "type") String type,
                            @RequestParam(value = "name") String name,
                            @RequestParam(value = "desc") String desc,
                            @RequestParam(value = "creater") String creater) {

        try {
            Param param = new Param();
            param.setType(type);
            param.setName(name);
            param.setDescs(desc);
            param.setCreater(creater);
            param.setState(1);
            paramService.addParam(param);
            return ComResp.success("添加成功！");
        } catch (Exception e) {
            return ComResp.error("添加失败！", e);
        }

    }


    /**
     * 分页查询参数
     * @param name
     * @param type
     * @param limit
     * @param page
     * @param sortCode
     * @param sortRole
     * @return
     */
    @GetMapping(value = "/getParamListByPage")
    public ComResp getParamListByPage(@RequestParam(value = "name", required = false) String name,
                                      @RequestParam(value = "type", required = false) String type,
                                      @RequestParam(value = "limit", required = false, defaultValue = "20") Integer limit,
                                      @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                      @RequestParam(value = "sortCode", required = false, defaultValue = "id") String sortCode,
                                      @RequestParam(value = "sortRole", required = false, defaultValue = "ASC") String sortRole) {

        Paging<Param> paging = new Paging<>(page, limit);

        try {
            paging.putSearch("name", name);
            paging.putSearch("type", type);
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
}
