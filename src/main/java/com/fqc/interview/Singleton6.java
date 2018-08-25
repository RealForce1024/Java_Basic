package com.fqc.interview;

/**
 * @author fqc
 * 静态内部类 单例
 */
public class Singleton6 {
    private static class SingletonHolder {
        private static final Singleton6 INSTANCE = new Singleton6();
    }

    private Singleton6() {

    }

    public static Singleton6 getInstance() {
        return SingletonHolder.INSTANCE;
    }

}
