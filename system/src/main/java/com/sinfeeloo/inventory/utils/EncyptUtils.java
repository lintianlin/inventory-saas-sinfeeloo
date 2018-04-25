package com.sinfeeloo.inventory.utils;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * @Author: mhj
 * @Desc:
 * @Date: 2018/4/25 16:59
 */
public class EncyptUtils {

    /**
     * Sha1加密
     * @param password
     * @return
     */
    public static String encyptBySha1(String password){
        RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
        String salt = randomNumberGenerator.nextBytes().toHex();
        return new SimpleHash("SHA-1", password).toHex();
    }
}
