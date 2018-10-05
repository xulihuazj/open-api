package com.xulihuazj.common.utils.convert;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cglib.core.Converter;
import org.springframework.util.CollectionUtils;

public class CachedBeanCopier {

    private static final Map<String, BeanCopier> BEAN_COPIERS = new HashMap();
    private static final Map<String, Converter> map = new HashMap();

    public CachedBeanCopier() {
    }

    public static <SourceType, TargetType> TargetType copyConvert(SourceType sourceObject, Class targetClass) {
        if (sourceObject != null && targetClass != null) {
            String key = genKey(sourceObject.getClass(), targetClass);
            BeanCopier copier;
            if (!BEAN_COPIERS.containsKey(key)) {
                copier = BeanCopier.create(sourceObject.getClass(), targetClass, true);
                BEAN_COPIERS.put(key, copier);
            } else {
                copier = (BeanCopier) BEAN_COPIERS.get(key);
            }

            Object converter;
            if (map.get("bean_convert") != null) {
                converter = (Converter) map.get("bean_convert");
            } else {
                converter = new BeanCopierConvertImpl();
                map.put("bean_convert", (Converter) converter);
            }

            try {
                Object targetObject = targetClass.newInstance();
                copier.copy(sourceObject, targetObject, (Converter) converter);
                return (TargetType) targetObject;
            } catch (IllegalAccessException | InstantiationException var6) {
                throw new RuntimeException(var6);
            }
        } else {
            return null;
        }
    }

    public static <OriginType, TargetType> List<TargetType> copyConvertList(List<OriginType> originObjs, Class targetTypeClass) {
        if (CollectionUtils.isEmpty(originObjs)) {
            return null;
        } else {
            List<TargetType> targetTypes = new ArrayList();
            Iterator var4 = originObjs.iterator();

            while (var4.hasNext()) {
                OriginType originType = (OriginType) var4.next();
                targetTypes.add(copyConvert(originType, targetTypeClass));
            }

            return targetTypes;
        }
    }

    private static String genKey(Class<?> sourceClazz, Class<?> targetClazz) {
        return sourceClazz.getName() + targetClazz.getName();
    }


}