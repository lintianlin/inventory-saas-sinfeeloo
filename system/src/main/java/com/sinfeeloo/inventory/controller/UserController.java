package com.sinfeeloo.inventory.controller;

import com.sinfeeloo.inventory.base.BaseController;
import com.sinfeeloo.inventory.entity.ComResp;
import com.sinfeeloo.inventory.entity.MyResponse;
import com.sinfeeloo.inventory.entity.Paging;
import com.sinfeeloo.inventory.entity.User;
import com.sinfeeloo.inventory.service.UserService;
import com.sinfeeloo.inventory.utils.EncyptUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
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


    /**
     * 退出
     *
     * @return
     */
    @RequestMapping(value = "/logout", method = {RequestMethod.POST, RequestMethod.GET})
    public ComResp loginOut() {
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return ComResp.success("退出成功！");
    }


    /**
     * 通过条件查询用户列表
     *
     * @param account
     * @param roleId
     * @param isLocked
     * @param limit
     * @param page
     * @return
     */
    @GetMapping(value = "/getUserListByPage")
    public ComResp getUserListByPage(@RequestParam(value = "account", required = false) String account,
                                     @RequestParam(value = "roleId", required = false) Integer roleId,
                                     @RequestParam(value = "isLocked", required = false) Integer isLocked,
                                     @RequestParam(value = "limit", required = false, defaultValue = "20") Integer limit,
                                     @RequestParam(value = "page", required = false, defaultValue = "1") Integer page) {
        Paging<User> paging = new Paging<>(page, limit);
        try {
            paging.putSearch("account", account);
            paging.putSearch("roleId", roleId);
            paging.putSearch("isLocked", isLocked);
            paging.putSearch("limit", limit);
            paging.putSearch("page", page);
            paging.putSearch("sortCode", "updatime");
            paging.putSearch("sortRole", "ASC");
            userService.getUserListByPage(paging);
            return ComResp.success("查询成功！", paging);
        } catch (Exception e) {
            logError("查询失败", e);
            return ComResp.error("查询失败！");
        }
    }

}
