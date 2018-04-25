package com.sinfeeloo.inventory.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * JsonUtil
 * @Author: mhj
 * @Desc:
 * @Date: 2018/4/25 8:51
 */
public class JsonUtil {

    private static ObjectMapper mapper;

    public static void initMapper() {
        if (mapper == null) {
            synchronized (JsonUtil.class) {
                if (mapper == null) {
                    mapper = new ObjectMapper();
                    mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
                    mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
                }
            }
        }
    }

    /**
     * json 转bean
     *
     * @param json
     * @param clss
     * @return T
     */
    public static <T> T jsonToBean(String json, Class<T> clss) {
        initMapper();
        try {
            return mapper.readValue(json, clss);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 实体类转json字符串
     *
     * @param obj
     * @return String
     */
    public static String beanToJson(Object obj) {
        initMapper();
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     *@Author:mhj
     *@Desc: json转list
     *@Date:2018/4/25 8:51
     */
    public static List<?> jsonToList(String jsonString, Class<?> clazz) {
        initMapper();
        JavaType javaType = getCollectionType(ArrayList.class, clazz);
        try {
            return mapper.readValue(jsonString, javaType);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    private static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }

}
