package com.fqc.suggest;

/**
 * @author fqc
 * <p>
 * thread.stop方法将破会锁对象逻辑的原子性
 */
public class TestThread {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();

        Thread t0 = new Thread(myThread);
        t0.start();

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(myThread, String.valueOf(i));
            thread.start();
        }

        t0.stop();
    }
}

class MyThread implements Runnable {
    private int num;

    @Override
    public void run() {
        synchronized ("") {
            num++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            num--;
            System.out.println("num = " + num);
        }
    }
}
