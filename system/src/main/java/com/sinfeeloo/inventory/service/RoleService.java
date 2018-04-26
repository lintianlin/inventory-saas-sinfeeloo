package com.sinfeeloo.inventory.service;

import com.sinfeeloo.inventory.entity.Paging;
import com.sinfeeloo.inventory.entity.Role;
import com.sinfeeloo.inventory.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: mhj
 * @Desc:角色管理
 * @Date: 2018/4/26 15:21
 */
@Service
public class RoleService {

    @Autowired
    private RoleMapper roleMapper;


    /**
     * 添加角色
     *
     * @param role
     */
    public void addRole(Role role) {
        roleMapper.insert(role);
    }

    /**
     * 通过名称查询该用户是否存在
     *
     * @param name
     * @return
     */
    public Role getRoleByName(String name) {
        return roleMapper.selectByName(name);
    }

    /**
     * 分页查询角色列表
     *
     * @param paging
     */
    public void getRoleListByPage(Paging<Role> paging) {
        paging.setTotal(roleMapper.selectRoleCount(paging.getSearchMap()));
        paging.setList(roleMapper.selectRoleListByPage(paging.getSearchMap()));
    }

    public int modifyRole(Role role) {
        return roleMapper.updateByPrimaryKey(role);
    }

    public int deleteRole(Integer roleId) {
        return roleMapper.deleteByPrimaryKey(roleId);
    }
}
