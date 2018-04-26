package com.sinfeeloo.inventory.service;

import com.sinfeeloo.inventory.entity.Paging;
import com.sinfeeloo.inventory.entity.User;
import com.sinfeeloo.inventory.mapper.UserMapper;
import com.sinfeeloo.inventory.utils.JWTUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: mhj
 * @Desc:
 * @Date: 2018/4/25 14:57
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 登陆
     *
     * @param account
     * @param password
     * @return
     */
    public User login(String account, String password) {
        UsernamePasswordToken uToken = new UsernamePasswordToken(account, password);
        Subject subject = SecurityUtils.getSubject();
        User user = userMapper.selectByAccount(account);
        if (user != null) {
            subject.login(uToken);
            String token = JWTUtil.sign(account);
            user.setToken(token);
            return user;
        }
        return null;
    }

    /**
     * 获得用户
     *
     * @param account
     * @return
     */
    public User getUserByAccount(String account) {
        return userMapper.selectByAccount(account);
    }

    public void addUser(User userTemp) {
        userMapper.insert(userTemp);
    }


    /**
     * 根据条件查询用户列表
     *
     * @param paging
     */
    public void getUserListByPage(Paging<User> paging) {
        paging.setTotal(userMapper.selectUserCount(paging.getSearchMap()));
        paging.setList(userMapper.selectUserListByPage(paging.getSearchMap()));
    }


    /**
     * 修改
     *
     * @param user
     */
    public int modifyUser(User user) {
        return userMapper.updateByPrimaryKey(user);
    }

    /**
     * 删除
     *
     * @param id
     */
    public int deleteUser(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    /**
     * 锁定
     *
     * @param id
     */
    public int lockUser(Integer id) {
        return userMapper.lockByPrimaryKey(id);
    }

}
