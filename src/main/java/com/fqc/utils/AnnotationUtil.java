package com.fqc.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;


public class AnnotationUtil {

    public static boolean isAnnotation(Method method) {
        if (method.isAnnotationPresent(Statistics.class)) {
            Annotation anot = method.getAnnotation(Statistics.class);
            Statistics log = (Statistics) anot;
            if (log.count()) {
                return true;
            }
        }
        return false;
    }

}