package com.fqc.concurrency;

import sun.awt.windows.ThemeReader;

/**
 * Created by fqc on 2016/1/4.
 */
public class SimpleTwoWayToBuildThread {




    public static void main(String[] args) {
        //1,2
        MyThread myThread = new MyThread();
        MyThread myThread2 = new MyThread();
        myThread.start();
        myThread2.start();
    }



}

class MyThread extends Thread {
//    private int a = 0; //1
    @Override
    public void run(){
        int a = 0; //2

        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep((long) (Math.random()*1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(a++);
        }
    }
}