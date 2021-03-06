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
    public ComResp addUser(@RequestParam(value = "account", required = true) String account,
                           @RequestParam(value = "roleId", required = true) Integer roleId,
                           @RequestParam(value = "roleName", required = true) String roleName,
                           @RequestParam(value = "employeeId", required = true) Integer employeeId,
                           @RequestParam(value = "operateAccount", required = true) String operateAccount) {
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
    public MyResponse login(@RequestParam(value = "account") String account,
                            @RequestParam(value = "password") String password) {
        MyResponse<User> response = new MyResponse();
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
                //不显示密码
                user.setPassword("");
                response.isSuccess("登陆成功!");
                response.setData(user);
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
    public ComResp logout() {
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


    /**
     * 修改用户
     *
     * @param id
     * @param account
     * @param roleId
     * @param roleName
     * @param employeeId
     * @param operateAccount
     * @return
     */
    @PostMapping(value = "/modifyUser")
    public ComResp modifyUser(@RequestParam(value = "id", required = true) Integer id,
                              @RequestParam(value = "account", required = true) String account,
                              @RequestParam(value = "roleId", required = true) Integer roleId,
                              @RequestParam(value = "roleName", required = true) String roleName,
                              @RequestParam(value = "employeeId", required = true) Integer employeeId,
                              @RequestParam(value = "operateAccount", required = true) String operateAccount) {

        try {
            User userTemp = new User();
            userTemp.setId(id);
            userTemp.setAccount(account);
            userTemp.setRoleid(roleId);
            userTemp.setRolename(roleName);
            userTemp.setEmployeeid(employeeId);
            userTemp.setUpdater(operateAccount);
            int num = userService.modifyUser(userTemp);
            return num > 0 ? ComResp.success("修改成功！") : ComResp.error("修改失败！");
        } catch (Exception e) {
            logError("用户修改失败！", e);
            return ComResp.error("修改失败！");
        }
    }


    /**
     * 删除
     *
     * @param id
     * @return
     */
    @PostMapping(value = "/deleteUser")
    public ComResp deleteUser(@RequestParam(value = "id", required = true) Integer id) {
        try {
            int num = userService.deleteUser(id);
            return num > 0 ? ComResp.success("删除成功！") : ComResp.error("删除失败！");
        } catch (Exception e) {
            logError("用户删除失败！", e);
            return ComResp.error("删除失败！");
        }
    }

    /**
     * 锁定/解锁
     *
     * @param id
     * @return
     */
    @PostMapping(value = "/operateLockUser")
    public ComResp operateLockUser(@RequestParam(value = "id", required = true) Integer id,
                                   @RequestParam(value = "isLocked", required = true, defaultValue = "1") Integer isLocked) {
        try {
            int num = userService.lockUser(id, isLocked);
            return num > 0 ? ComResp.success("操作成功！") : ComResp.error("操作失败！");
        } catch (Exception e) {
            logError("用户操作锁失败！", e);
            return ComResp.error("操作失败！");
        }
    }


    @PostMapping(value = "/modifyPassword")
    public ComResp modifyPassword(@RequestParam(value = "id", required = true) Integer id,
                                  @RequestParam(value = "oldPwd", required = true) String oldPwd,
                                  @RequestParam(value = "newPwd", required = true) String newPwd) {

        try {

            if (StringUtils.isBlank(oldPwd)) {
                return ComResp.error("原始密码不能为空！");
            }
            if (StringUtils.isBlank(newPwd)) {
                return ComResp.error("新密码不能为空！");
            }
            //检查原始密码是否正确
            if (!userService.checkUserPwd(id, oldPwd)) {
                return ComResp.error("原密码不正确！");
            }
            int num = userService.modifyPwd(id, newPwd);
            return num > 0 ? ComResp.success("修改成功！") : ComResp.error("修改失败！");
        } catch (Exception e) {
            return ComResp.error("修改失败！", e);
        }
    }

}
