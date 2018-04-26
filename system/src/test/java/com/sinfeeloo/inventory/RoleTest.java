package com.sinfeeloo.inventory;

import com.sinfeeloo.inventory.base.BaseTest;
import com.sinfeeloo.inventory.controller.RoleController;
import com.sinfeeloo.inventory.controller.UserController;
import com.sinfeeloo.inventory.entity.ComResp;
import com.sinfeeloo.inventory.entity.MyResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author: mhj
 * @Desc:角色管理测试
 * @Date: 2018/4/26 13:20
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RoleTest extends BaseTest {

    @Autowired
    private RoleController roleController;


    @Test
    public void addRole() {
        ComResp resp = roleController.addRole("总经理",
                "ZJL",
                "总经理管理系统和数据",
                "4,1,10,11,12,22,24,25,26,5,27,28",
                "库存管理,基础设置,商品管理,仓库管理,员工管理,基础参数,库存查看,采购审核,销售审核,统计分析,采购统计,销售统计",
                "admin2");
        printResponse(resp);
    }

    @Test
    public void getRoleListByPage() {
        ComResp resp = roleController.getRoleListByPage("", "ZJL", 1, 10);
        printResponse(resp);
    }

    @Test
    public void modifyRole() {
        ComResp resp = roleController.modifyRole(11,
                "总经理OK",
                "ZJLOK",
                "总经理管理系统和数据",
                "4,1,10,11,12,22,24,25,26,5,27,28",
                "库存管理,基础设置,商品管理,仓库管理,员工管理,基础参数,库存查看,采购审核,销售审核,统计分析,采购统计,销售统计",
                "admin2");
        printResponse(resp);
    }

    @Test
    public void deleteRole() {
        ComResp resp = roleController.deleteRole(11);
        printResponse(resp);
    }

}
