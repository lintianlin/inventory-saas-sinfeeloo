package com.sinfeeloo.inventory.utils;


import java.util.UUID;

/**
 * @author MYM
 */
public class UUIDUtil {

    /**
     * 产生一个32位的UUUID
     *
     * @return
     */
    public static String UUIDGenerators() {
        String s = UUID.randomUUID().toString().trim().replaceAll("-", "");
        return s;
    }

    /**
     * 产生一个中间带有中横线的32位UUUID
     *
     * @return
     */
    public static String UUIDGenerLine() {
        String s = UUID.randomUUID().toString().trim();
        return s;
    }
}