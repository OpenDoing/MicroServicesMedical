package com.medical.patientinfo.util;

import net.sf.cglib.beans.BeanCopier;

/**
 * @author duwen
 * @date 2019/1/14 17:25
 */
public class BeanCopyUtil {

    /**
     * 实现两个对象的复制
     * @param source 源对象
     * @param target 目标对象
     */
    public static void copy(Object source, Object target) {
        BeanCopier beanCopier = BeanCopier.create(source.getClass(), target.getClass(), false);
        beanCopier.copy(source, target, null);
    }
}
