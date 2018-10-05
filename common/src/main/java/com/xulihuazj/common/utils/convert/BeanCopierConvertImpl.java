package com.xulihuazj.common.utils.convert;


import java.util.Map;

import com.xulihuazj.common.utils.JSONHelper;
import org.springframework.cglib.core.Converter;

public class BeanCopierConvertImpl implements Converter {
    public BeanCopierConvertImpl() {
    }

    public Object convert(Object sourceObject, Class targetClass, Object context) {
        if (sourceObject instanceof Integer && targetClass.getTypeName().equals("java.lang.Long")) {
            return ((Integer)sourceObject).longValue();
        } else if (sourceObject instanceof Long && targetClass.getTypeName().equals("java.lang.Integer")) {
            return ((Long)sourceObject).intValue();
        } else if (sourceObject instanceof Long && targetClass.getTypeName().equals("java.lang.String")) {
            return String.valueOf(sourceObject);
        } else if (sourceObject instanceof String && targetClass.getTypeName().equals("java.lang.Long")) {
            return Long.parseLong((String)sourceObject);
        } else if (sourceObject instanceof Integer && targetClass.getTypeName().equals("java.lang.String")) {
            return String.valueOf(sourceObject);
        } else if (sourceObject instanceof String && targetClass.getTypeName().equals("java.lang.Integer")) {
            return Integer.parseInt((String)sourceObject);
        } else if (sourceObject != null && sourceObject.getClass().isEnum() && targetClass.getTypeName().equals("java.lang.String")) {
            return ((Enum)sourceObject).name();
        } else if (sourceObject instanceof String && targetClass.isEnum()) {
            return Enum.valueOf(targetClass, sourceObject.toString());
        } else if (sourceObject != null && sourceObject.getClass().isEnum() && targetClass.isEnum()) {
            return Enum.valueOf(targetClass, ((Enum)sourceObject).name());
        } else if (sourceObject instanceof Map && targetClass.getTypeName().equals("java.lang.String")) {
            return JSONHelper.toJson(sourceObject);
        } else {
            return sourceObject instanceof String && targetClass.getTypeName().equals("java.util.Map") ? JSONHelper.toObject((String)sourceObject, Map.class) : sourceObject;
        }
    }
}