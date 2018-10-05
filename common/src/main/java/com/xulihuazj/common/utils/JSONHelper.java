package com.xulihuazj.common.utils;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;

public class JSONHelper {

    /**
     * 系列化json
     *
     * @param object
     * @return
     */
    public static String toJoson(Object object) {
        if (null == object) {
            return null;
        }
        return JSON.toJSONString(object);
    }

    /**
     * 反序列化object
     *
     * @param json
     * @return
     */
    public static <T> T toObject(String json, Class<T> tClass) {
        if (StringUtils.isBlank(json)) {
            return null;
        }
        return JSON.parseObject(json, tClass);
    }
}
