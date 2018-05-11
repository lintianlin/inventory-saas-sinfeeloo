package com.sinfeeloo.inventory.service;

import com.sinfeeloo.inventory.entity.Menu;
import com.sinfeeloo.inventory.mapper.MenuMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: mhj
 * @Desc:
 * @Date: 2018/4/27 14:30
 */
@Service
public class MenuService {

    @Autowired
    private MenuMapper menuMapper;

    /**
     * 询菜单名称或路径查是否重复
     *
     * @param name
     * @return
     */
    public boolean checkNameOrPathIsRepeat(String name, String path) {
        List<Menu> list = menuMapper.selectByNameOrPath(name, path);
        return list.size() > 0;
    }

    /**
     * 添加菜单
     *
     * @param menu
     */
    public void addMenu(Menu menu) {
        menuMapper.insert(menu);
    }

    /**
     * 获取菜单列表
     *
     * @param menuIdstr
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public List<Menu> getMenuList(String menuIdstr) {
        if (StringUtils.isBlank(menuIdstr)) {//如果是空，返回全部菜单列表
            return menuMapper.selectAll();
        } else {
            String[] ids = menuIdstr.split(",");
            List<Menu> menuList = new ArrayList<>();
            if (null != ids && ids.length > 0) {
                for (int i = 0; i < ids.length; i++) {
                    Menu menu = menuMapper.selectByPrimaryKey(Integer.parseInt(ids[i]));
                    if (0 == menu.getIsleaf()) {//判断是否是根节点
                        menuList.add(menu);
                    } else {//如果不是根节点
                        for (int j = 0; j < menuList.size(); j++) {
                            //如果子菜单的父节点id等于根节点的id，则说明是他的孩子
                            if(menu.getUpid()==menuList.get(j).getId()){
                                menuList.get(j).getChildren().add(menu);
                            }
                        }
                    }
                }
            }
            return menuList;
        }
    }

    /**
     * 修改
     *
     * @param menu
     */
    public int modifyMenu(Menu menu) {
        return menuMapper.updateByPrimaryKey(menu);
    }

    /**
     * 删除
     *
     * @param id
     * @param updater
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public void deleteMenu(Integer id, String updater) {
        Menu menu = menuMapper.selectByPrimaryKey(id);
        if (null != menu) {
            //是子节点，则直接删除;
            if (0 == menu.getIsleaf()) {//如果是根节点，则首先查出根节点下面所有的子节点删除掉，然后删除自己
                List<Menu> childMenus = menuMapper.selectByUpId(id);
                for (Menu m : childMenus) {
                    Menu temp = new Menu();
                    temp.setId(m.getId());
                    temp.setUpdater(updater);
                    menuMapper.deleteByPrimaryKey(temp);
                }
            }
            //删除根节点
            Menu temp = new Menu();
            temp.setId(id);
            temp.setUpdater(updater);
            menuMapper.deleteByPrimaryKey(temp);
        }
    }
}
