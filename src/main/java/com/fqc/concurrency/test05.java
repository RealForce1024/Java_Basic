package com.fqc.concurrency;

public class test05 {
    public static void main(String[] args) {
        SyncDouble sd = new SyncDouble();
        new Thread(() -> sd.m1()).start();
        new Thread(() -> sd.m1()).start();
    }
}

class SyncDouble {
    public synchronized void m1() {
        System.out.println("SyncDouble.m1");
        m2();
    }

    public synchronized void m2() {
        System.out.println("SyncDouble.m2");
        m3();
    }

    public synchronized void m3() {
        System.out.println("SyncDouble.m3");
        m4();
    }

    public synchronized void m4() {
        System.out.println("SyncDouble.m4");
        m5();
    }

    public synchronized void m5() {
        System.out.println("SyncDouble.m5");
    }
}
