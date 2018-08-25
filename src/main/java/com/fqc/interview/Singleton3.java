package com.fqc.interview;

/**
 * @author fqc
 * 低效非线程安全的懒汉式(不推荐使用)
 */
public class Singleton3 {
    private static Singleton3 instance;

    private Singleton3() {

    }

    public synchronized static Singleton3 getInstance() {
        if (instance == null) {
            instance = new Singleton3();
        }
        return instance;
    }
}
