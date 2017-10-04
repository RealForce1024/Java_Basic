package com.fqc.concurrency;

public class test06 {
    public static void main(String[] args) {
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
    @Override
    public  void sub() {
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
