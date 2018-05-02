package com.sinfeeloo.inventory.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: mhj
 * @Desc:
 * @Date: 2018/5/2 16:37
 */
public class CommonUtils {

    /**
     * 验证邮箱
     * @param string
     * @return
     */
    public static boolean isEmail(String string) {
        if (string == null)
            return false;
        String regEx1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern p;
        Matcher m;
        p = Pattern.compile(regEx1);
        m = p.matcher(string);
        if (m.matches())
            return true;
        else
            return false;
    }
}
