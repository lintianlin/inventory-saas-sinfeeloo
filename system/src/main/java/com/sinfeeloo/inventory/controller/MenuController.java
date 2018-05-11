package com.sinfeeloo.inventory.controller;

import com.sinfeeloo.inventory.entity.ComResp;
import com.sinfeeloo.inventory.entity.Menu;
import com.sinfeeloo.inventory.entity.User;
import com.sinfeeloo.inventory.service.MenuService;
import com.sinfeeloo.inventory.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: mhj
 * @Desc:
 * @Date: 2018/4/27 14:29
 */
@RestController
@RequestMapping(value = "/menu")
public class MenuController {


    @Autowired
    private MenuService menuService;
    @Autowired
    private UserService userService;


    /**
     * 添加菜单
     *
     * @param name
     * @param path
     * @param isLeaf
     * @param upId
     * @param updater
     * @return
     */
    @PostMapping(value = "/addMenu")
    public ComResp addMenu(@RequestParam(value = "name", required = true) String name,
                           @RequestParam(value = "path", required = true) String path,
                           @RequestParam(value = "isLeaf", required = true) Integer isLeaf,
                           @RequestParam(value = "upId", required = true) Integer upId,
                           @RequestParam(value = "updater", required = true) String updater) {

        try {
            if (StringUtils.isBlank(name)) {
                return ComResp.error("菜单名称不能为空！");
            }
            if (StringUtils.isBlank(path)) {
                return ComResp.error("菜单路径不能为空！");
            }
            if (menuService.checkNameOrPathIsRepeat(name, path)) {
                return ComResp.error("菜单名称或路径已存在！");
            }
            Menu menu = new Menu();
            menu.setName(name);
            menu.setPath(path);
            menu.setIsleaf(isLeaf);
            menu.setUpid(upId);
            menu.setState(1);
            menu.setUpdater(updater);
            menuService.addMenu(menu);
            return ComResp.success("添加成功！");
        } catch (Exception e) {
            return ComResp.error("添加失败！", e);
        }

    }


    /**
     * 查询菜单列表
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/getMenuList")
    public ComResp getMenuList(@RequestParam(value = "userId") Integer id) {
        try {
            User user = userService.getUsersMenuByUserId(id);
            if (null == user) {
                return ComResp.error("该用户不存在！");
            }
            String menuIdstr = user.getMenuIds();
            List<Menu> menuList = menuService.getMenuList(menuIdstr);
            return ComResp.success("查询成功！", menuList);

        } catch (Exception e) {
            return ComResp.error("查询失败！", e);
        }
    }


    /**
     * 添加菜单
     *
     * @param name
     * @param path
     * @param isLeaf
     * @param upId
     * @param updater
     * @return
     */
    @PostMapping(value = "/modifyMenu")
    public ComResp modifyMenu(
            @RequestParam(value = "id", required = true) Integer id,
            @RequestParam(value = "name", required = true) String name,
            @RequestParam(value = "path", required = true) String path,
            @RequestParam(value = "isLeaf", required = true) Integer isLeaf,
            @RequestParam(value = "upId", required = true) Integer upId,
            @RequestParam(value = "updater", required = true) String updater) {

        try {
            if (StringUtils.isBlank(name)) {
                return ComResp.error("菜单名称不能为空！");
            }
            if (StringUtils.isBlank(path)) {
                return ComResp.error("菜单路径不能为空！");
            }
            if (menuService.checkNameOrPathIsRepeat(name, path)) {
                return ComResp.error("菜单名称或路径已存在！");
            }
            Menu menu = new Menu();
            menu.setId(id);
            menu.setName(name);
            menu.setPath(path);
            menu.setIsleaf(isLeaf);
            menu.setUpid(upId);
            menu.setUpdater(updater);
            int num = menuService.modifyMenu(menu);
            return num > 0 ? ComResp.success("修改成功！") : ComResp.error("修改失败！");
        } catch (Exception e) {
            return ComResp.error("修改失败！", e);
        }
    }


    /**
     * 删除菜单
     *
     * @param id
     * @param updater
     * @return
     */
    @PostMapping(value = "/deleteMenu")
    public ComResp deleteMenu(@RequestParam(value = "id") Integer id,
                              @RequestParam(value = "updater") String updater) {
        try {
            menuService.deleteMenu(id, updater);
            return ComResp.success("删除成功！");
        } catch (Exception e) {
            return ComResp.error("删除失败！", e);
        }
    }

}
