package com.sinfeeloo.inventory.controller;

import com.sinfeeloo.inventory.entity.ComResp;
import com.sinfeeloo.inventory.entity.Paging;
import com.sinfeeloo.inventory.entity.Role;
import com.sinfeeloo.inventory.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: mhj
 * @Desc:角色管理
 * @Date: 2018/4/26 15:20
 */
@RestController
@RequestMapping(value = "/role")
public class RoleController {

    @Autowired
    private RoleService roleService;


    @PostMapping(value = "/addRole")
    public ComResp addRole(@RequestParam(value = "roleName", required = true) String roleName,
                           @RequestParam(value = "roleCode", required = true) String roleCode,
                           @RequestParam(value = "roleDesc", required = true) String roleDesc,
                           @RequestParam(value = "menuIds", required = true) String menuIds,
                           @RequestParam(value = "menuNames", required = true) String menuNames,
                           @RequestParam(value = "updater", required = true) String updater) {

        try {
            Role temp = roleService.getRoleByName(roleName);
            if (null != temp) {
                return ComResp.error("该角色名称已存在！");
            }
            Role role = new Role();
            role.setName(roleName);
            role.setCode(roleCode);
            role.setDescs(roleDesc);
            role.setMenuids(menuIds);
            role.setMenunames(menuNames);
            role.setState(1);
            role.setUpdater(updater);
            roleService.addRole(role);
            return ComResp.success("添加成功！");
        } catch (Exception e) {
            return ComResp.error("添加失败！");
        }

    }

    @GetMapping(value = "/getRoleListByPage")
    public ComResp getRoleListByPage(@RequestParam(value = "roleName", required = false) String roleName,
                                     @RequestParam(value = "roleCode", required = false) String roleCode,
                                     @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                     @RequestParam(value = "limit", required = false, defaultValue = "20") Integer limit) {
        Paging<Role> paging = new Paging<>(page, limit);
        try {
            paging.putSearch("roleName", roleName);
            paging.putSearch("roleCode", roleCode);
            paging.putSearch("limit", limit);
            paging.putSearch("page", page);
            paging.putSearch("sortCode", "updatime");
            paging.putSearch("sortRole", "ASC");
            roleService.getRoleListByPage(paging);
            return ComResp.success("查询成功！", paging);
        } catch (Exception e) {
            return ComResp.error("查询失败！", e);
        }

    }


    @PostMapping(value = "/modifyRole")
    public ComResp modifyRole(@RequestParam(value = "roleId", required = true) Integer roleId,
                              @RequestParam(value = "roleName", required = true) String roleName,
                              @RequestParam(value = "roleCode", required = true) String roleCode,
                              @RequestParam(value = "roleDesc", required = true) String roleDesc,
                              @RequestParam(value = "menuIds", required = true) String menuIds,
                              @RequestParam(value = "menuNames", required = true) String menuNames,
                              @RequestParam(value = "updater", required = true) String updater) {
        try {
            Role role = new Role();
            role.setId(roleId);
            role.setName(roleName);
            role.setCode(roleCode);
            role.setDescs(roleDesc);
            role.setMenuids(menuIds);
            role.setMenunames(menuNames);
            role.setUpdater(updater);
            int num = roleService.modifyRole(role);
            return num > 0 ? ComResp.success("修改成功！") : ComResp.error("修改失败！");
        } catch (Exception e) {
            return ComResp.error("修改失败！", e);
        }

    }

    /**
     * 删除
     * @param roleId
     * @return
     */
    @PostMapping(value = "/deleteRole")
    public ComResp deleteRole(@RequestParam(value = "roleId", required = true) Integer roleId) {
        try {
            int num = roleService.deleteRole(roleId);
            return num > 0 ? ComResp.success("删除成功！") : ComResp.error("删除失败！");
        } catch (Exception e) {
            return ComResp.error("删除失败！", e);
        }
    }
}
