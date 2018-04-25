package com.sinfeeloo.inventory.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTUtil {

    // 过期时间5分钟
    private static final long EXPIRE_TIME = 5 * 60 * 1000;
    //密钥
    private static final String  SECRET = "14C45C05-1B50-58D3-A544-96E6E77FBB3B";

    /**
     * 校验token是否正确
     *
     * @param token
     * @return 是否正确
     */
    public static Map<String, Claim> verify(String token) {
        DecodedJWT jwt= null;
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            JWTVerifier verifier = JWT.require(algorithm)
                    .build();
            jwt = verifier.verify(token);
        } catch (Exception exception) {
            throw  new RuntimeException("token 无效");
        }
        return jwt.getClaims();
    }

    /**
     * 获得token中的信息无需secret解密也能获得*
     * @return token中包含的用户名
     */
    public static String getUsername(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("account").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 生成签名,5min后过期
     *
     * @param account 用户名
     * @return 加密的token
     */
    public static String sign(String account) {
        try {
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            Map<String,Object> map = new HashMap<>();
            map.put("alg","HS256");
            map.put("type","JWT");
            // 附带username信息
            return JWT.create()
                    .withHeader(map)
                    .withClaim("account", account)
                   // .withExpiresAt(date)
                    .withIssuedAt(new Date())
                    .sign(algorithm);
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }
}