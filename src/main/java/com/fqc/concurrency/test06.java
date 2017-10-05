package com.fqc.concurrency;

import com.fqc.utils.Statistics;

public class test06 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Son son = new Son();
        new Thread(() -> son.sub()).start();
        new Thread(() -> son.sub()).start();
    }
}

class Parent {
    public int i = 10;

    public synchronized void sub() {
        i--;
        System.out.println("parent = " + i);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Son extends Parent {
    @Statistics(count = true)
    public synchronized void sub() {
        while (i > 0) {
            i--;
            System.out.println("sub = " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            super.sub();
        }
    }
}
