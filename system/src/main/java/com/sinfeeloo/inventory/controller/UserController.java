package com.sinfeeloo.inventory.controller;

import com.sinfeeloo.inventory.base.BaseController;
import com.sinfeeloo.inventory.entity.ComResp;
import com.sinfeeloo.inventory.entity.MyResponse;
import com.sinfeeloo.inventory.entity.User;
import com.sinfeeloo.inventory.service.UserService;
import com.sinfeeloo.inventory.utils.EncyptUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: mhj
 * @Desc:用户
 * @Date: 2018/4/25 14:56
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {


    @Autowired
    UserService userService;

    @PostMapping(value = "/addUser")
    public ComResp addTeam(@RequestParam(value = "account", required = true) String account,
                           @RequestParam(value = "roleId", required = true) Integer roleId,
                           @RequestParam(value = "roleName", required = true) String roleName,
                           @RequestParam(value = "employeeId", required = true) Integer employeeId,
                           @RequestParam(value = "operateAccount", required = true) String operateAccount) {
        MyResponse response = new MyResponse();

        User user = userService.getUserByAccount(account);
        if (user != null) {
            return ComResp.error("该用户已存在！");
        }
        User userTemp = new User();
        userTemp.setAccount(account);
        userTemp.setPassword(EncyptUtils.encyptBySha1("123456"));
        userTemp.setRoleid(roleId);
        userTemp.setRolename(roleName);
        userTemp.setEmployeeid(employeeId);
        userTemp.setUpdater(operateAccount);
        userTemp.setIslocked(0);
        userTemp.setState(1);
        userService.addUser(userTemp);
        return ComResp.success("添加成功！");
    }

    /**
     * 登陆
     *
     * @param account
     * @param password
     * @return
     */
    @PostMapping(value = "/login")
    public MyResponse teamLogin(@RequestParam(value = "account") String account,
                                @RequestParam(value = "password") String password) {
        MyResponse<String> response = new MyResponse();
        try {
            if (StringUtils.isBlank(account)) {
                response.isError("用户名不能为空");
                return response;
            }
            if (StringUtils.isBlank(password)) {
                response.isError("密码不能为空");
                return response;
            }

            User user = userService.login(account, password);
            if (null != user) {
                response.isSuccess("登陆成功!");
                response.setData(user.getToken());
            } else {
                response.isError("用户不存在！");
            }
        } catch (AuthenticationException authenticationException) {
            response.isError("用户名或密码不正确！");
        } catch (Exception ex) {
            logError("登录失败！", response, ex);
        }
        return response;
    }

}
