package com.lyn.eshop.common.util;

import net.sf.cglib.beans.BeanCopier;

import java.util.HashMap;
import java.util.Map;

/**
 * 基于原型模式 和  享元模式 实现对象的copy
 * 对象copy组件
 * @program: projects
 * @author: lyn
 * * @create: 2021-05-09 14:15
 **/
public class BeanCopierUtils {

    public static Map<String, BeanCopier> beanCopierCacheMap = new HashMap<>();

    /**
     * 将source对象的属性copy到target对象中
     * @param source
     * @param target
     */
    public static void copyProperties(Object source, Object target) {
        String cacheKey = source.getClass().toString() + target.getClass().toString();

        BeanCopier beanCopier = null;

        if (!beanCopierCacheMap.containsKey(cacheKey)) {
            synchronized (BeanCopierUtils.class) {
                if (!beanCopierCacheMap.containsKey(cacheKey)) {
                    beanCopier = BeanCopier.create(source.getClass(), target.getClass(), false);
                    beanCopierCacheMap.put(cacheKey, beanCopier);
                } else {
                    beanCopier = beanCopierCacheMap.get(cacheKey);
                }
            }
        } else {
            beanCopier = beanCopierCacheMap.get(cacheKey);
        }
        beanCopier.copy(source, target, null);
    }
}
