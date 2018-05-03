package com.sinfeeloo.inventory.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: mhj
 * @Desc:
 * @Date: 2018/5/2 16:15
 */
public class DateUtils {


    /**
     * 2018-05-02 字符串日期格式转日期（Date）
     * @param dateStr
     * @return
     */
    public static Date str2Date(String dateStr) {
        Date date = null;
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return format.parse(dateStr);
        } catch (ParseException e) {
            return null;
        }
    }


}
