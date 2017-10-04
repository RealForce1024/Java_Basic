package com.fqc.concurrency;

public class test02 {
    public static void main(String[] args) {
        new Thread(() -> new MyThread02().printNum("task1")).start();
        new Thread(() -> new MyThread02().printNum("task2")).start();
    }
}

class MyThread02 {
    //private int i = 10;
    private static int num = 10; //fix

    //public  synchronized void printNum(String flag) {
    public static synchronized void printNum(String flag) { //fix
        if (flag.equals("task1")) {
            num = 100;
            System.out.println("set task1");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            num = 200;
            System.out.println("set task2");
        }
        System.out.println("flag:" + flag + " i:" + num);
    }
}

