package com.fqc.suggest;

/**
 * @author fqc
 */
public class StopThread {
    public static void main(String[] args) {

        MyThread2 t = new MyThread2();
        ThreadController threadController = new ThreadController(t);
        int count = 0;

        while (threadController.isFlag()) {
            threadController.startThread();
            if (10 == count++) {
                threadController.terminate();
            }
        }
    }
}

class MyThread2 implements Runnable {
    @Override
    public void run() {
        System.out.println("thread running...");
    }

}

class ThreadController {

    private MyThread2 myThread2;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean flag = true;

    public ThreadController(MyThread2 thread) {
        this.myThread2 = thread;
    }


    public void terminate() {
        setFlag(false);
        System.out.println("thread stopping...");
    }

    public void startThread() {
        myThread2.run();
    }

}

