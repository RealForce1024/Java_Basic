package com.fqc.utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


public class AspectHandler implements InvocationHandler {

    //被代理的目标对象
    private Object target;


    public AspectHandler(Object target) {
        super();
        this.target = target;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {


        Method loggerMethod = target.getClass().getMethod(method.getName(),
                method.getParameterTypes());

        if (AnnotationUtil.isAnnotation(loggerMethod)) {
            long startTime = System.currentTimeMillis();
            Object ret = method.invoke(target, args);
            System.out.println(String.format("方法%s执行的时间%d", method.getName(), System.currentTimeMillis() - startTime));
            return ret;
        }
        return method.invoke(target, args);
    }

}