package com.fqc.interview;

/**
 * @author fqc
 * 重校验锁线程安全懒汉式（不推荐使用）
 */
public class Singleton5 {
    private volatile static Singleton5 instance;

    private Singleton5() {

    }

    public static Singleton5 getInstance() {
        if (instance == null) {
            synchronized (Singleton5.class) {
                if (instance == null) {
                    instance = new Singleton5();
                }
            }
        }
        return instance;
    }
}
