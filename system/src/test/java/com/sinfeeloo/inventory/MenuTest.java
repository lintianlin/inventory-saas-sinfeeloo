package com.sinfeeloo.inventory;

import com.sinfeeloo.inventory.base.BaseTest;
import com.sinfeeloo.inventory.controller.MenuController;
import com.sinfeeloo.inventory.entity.ComResp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author: mhj
 * @Desc:
 * @Date: 2018/4/27 15:13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MenuTest extends BaseTest {

    @Autowired
    private MenuController menuController;


    @Test
    public void addMenu() {
        ComResp resp = menuController.addMenu("测试管理", "/admin/test", 0, 0, "admin2");
        printResponse(resp);
    }

    @Test
    public void addMenu2() {
        ComResp resp = menuController.addMenu("测试子菜单", "/admin/test2", 1, 34, "admin2");
        printResponse(resp);
    }

    @Test
    public void getMenuList() {
        ComResp resp = menuController.getMenuList(1);
        printResponse(resp);
    }

    @Test
    public void modifyMenu() {
        ComResp resp = menuController.modifyMenu(35, "测试子菜单修改", "/admin/testmodify/", 1, 34, "admin2");
        printResponse(resp);
    }

    @Test
    public void delete() {
        ComResp resp = menuController.deleteMenu(5, "admin2");
        printResponse(resp);
    }

}
