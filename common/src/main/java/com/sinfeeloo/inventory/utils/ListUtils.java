package com.sinfeeloo.inventory.utils;

import java.util.List;

/**
 * @Author: mhj
 * @Desc:
 * @Date: 2018/4/18 12:01
 */
public class ListUtils {

    public static boolean notEmpty(List list) {
        if (null != list && list.size() > 0) {
            return true;
        }
        return false;
    }
}
