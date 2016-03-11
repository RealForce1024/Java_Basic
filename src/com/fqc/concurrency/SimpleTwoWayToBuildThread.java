package com.fqc.concurrency;

import com.fqc.io.IOUtils;

/**
 * Created by fqc on 2016/1/4.
 */
public class SimpleTwoWayToBuildThread {

    public static void main(String[] args) {
        //Test1();
        Test2();


    }

    private static void Test2() {
        MyThread2 myThread1 = new MyThread2();
        MyThread2 myThread2 = new MyThread2();

        Thread t1 = new Thread(myThread1, "Thread-1");
        Thread t2 = new Thread(myThread2, "Thread-2");

        t1.start();
        t2.start();
    }


    private static void Test1() {
        //1,2
        MyThread myThread = new MyThread("Thread-1");
        MyThread myThread2 = new MyThread("Thread-2");


        myThread.start();
        myThread2.start();

        //以下方式是将两线程类当成是普通类来处理。
        //结果是 main-1-100 *2
        //切不可直接调用线程类的run方法，而是通过start方法来调用。
        myThread.run();
        myThread2.run();
    }

}

class MyThread extends Thread {


    private int a = 0; //1

    public MyThread(String name) {
        super(name);
    }

    public MyThread() {

    }

    @Override
    public void run() {
        //int a = 0; //2
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.currentThread().getName() + "---" + a++);

        }
    }
}

class MyThread2 implements Runnable {
    private int a = 0; //1

    @Override
    public void run() {
        //int a = 0; //2
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //System.out.println(this.currentThread().getName() + "---" + a++);
            System.out.println(Thread.currentThread().getName() + "---" + a++);

        }
    }
}