package com.fqc.utils;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApplicationContext {
    private static ApplicationContext instance = null;
    private Map<String, Object> objsMap = null;

    public static ApplicationContext getInstance() throws InstantiationException, IllegalAccessException {
        if (instance == null) {
            synchronized (ApplicationContext.class) {
                if (instance == null) {
                    instance = new ApplicationContext();
                }
            }
        }
        return instance;
    }

    private ApplicationContext() throws InstantiationException, IllegalAccessException {
        objsMap = new HashMap<String, Object>();
        init();
    }

    public void init() throws InstantiationException, IllegalAccessException {
        //查找com.junjiex这个包和子包里面的方法
        List<Class<?>> classes = ClassUtils.getClasses("com.fqc.concurrency");
        for (Class<?> clas : classes) {
            //只有Component的类才放到bean缓存里
            if (clas.isAnnotationPresent(Component.class)) {
                if (!clas.isAnnotation() && !clas.isInterface() && !clas.isEnum()) {
                    Object instance = clas.newInstance();
                    Object obj = Proxy.newProxyInstance(instance.getClass().getClassLoader(), instance.getClass().getInterfaces(), new AspectHandler(instance));
                    objsMap.put(instance.getClass().getSimpleName(), obj);
                }
            }

        }
        System.out.println(classes);
    }

    public Object getBean(String className) {
        if (!objsMap.containsKey(className)) {
            throw new RuntimeException("the bean not found!");
        }
        return objsMap.get(className);
    }
}