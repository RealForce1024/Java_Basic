package com.fqc.concurrency;

public class test01 {
    public static void main(String[] args) {
        new Thread(new MyThreadTest()).start();
        new Thread(new MyThreadTest2()).start();

        new Thread(() -> System.out.println("hello java8 runnable")).start();
    }
}

class MyThreadTest extends Thread {
    @Override
    public void run() {
        System.out.println("MyThreadTest.run");
    }
}

class MyThreadTest2 implements Runnable {
    @Override
    public void run() {
        System.out.println("MyThreadTest2.run");
    }
}
