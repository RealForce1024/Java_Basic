package com.fqc.interview;

/**
 * @author fqc
 * 重校验锁线程安全懒汉式（不推荐使用）
 */
public class Singleton4 {
    private static Singleton4 instance;

    private Singleton4() {

    }

    public static Singleton4 getInstance() {
        if (instance == null) {
            synchronized (Singleton4.class) {
                if (instance == null) {
                    instance = new Singleton4();
                }
            }
        }
        return instance;
    }
}
