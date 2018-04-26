package com.sinfeeloo.inventory;

import com.sinfeeloo.inventory.base.BaseTest;
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
 * @Desc:
 * @Date: 2018/4/26 13:20
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserTest extends BaseTest {

    @Autowired
    private UserController userController;


    @Test
    public void addUser() {
        ComResp resp = userController.addUser("lisi", 3, "销售员", 1, "admin");
        printResponse(resp);
    }

    @Test
    public void login() {
        MyResponse resp = userController.login("lisi", "123456");
        printResponse(resp);
    }

    @Test
    public void getUserListByPage() {
        ComResp resp = userController.getUserListByPage("", 0, 0, 10, 1);
        printResponse(resp);
    }

    @Test
    public void updateUser() {
        ComResp resp = userController.modifyUser(12, "丽琪", 3, "销售员", 7, "admin2");
        printResponse(resp);
    }

    @Test
    public void deleteUser() {
        ComResp resp = userController.deleteUser(12);
        printResponse(resp);
    }

    @Test
    public void logout() {
        ComResp resp = userController.logout();
        printResponse(resp);
    }

    @Test
    public void lockUser(){
        ComResp resp = userController.operateLockUser(13,1);
        printResponse(resp);
    }

    @Test
    public void unlockUser(){
        ComResp resp = userController.operateLockUser(13,0);
        printResponse(resp);
    }
}
