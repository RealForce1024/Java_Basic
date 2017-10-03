package com.fqc.concurrency;

public class test03 {
    public static void main(String[] args) {
        MyObject myObject = new MyObject();
        new Thread(() -> myObject.m1()).start();
        new Thread(() -> myObject.m2()).start();
    }
}

class MyObject {
    public void m1() {
        System.out.println("m1");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void m2() {
        System.out.println("m2");
    }
}
