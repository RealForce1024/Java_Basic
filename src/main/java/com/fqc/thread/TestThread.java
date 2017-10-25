package com.fqc.thread;

/**
 * @author fqc
 */
public class TestThread {
    public static void main(String[] args) {
        Example example = new Example();
        TheThread t1 = new TheThread(example);
        TheThread t2 = new TheThread(example);
        t1.start();
        t2.start();
    }
}

class Example {
    public int num = 20;

    public void execute() {
        for (int i = 0; i < 10; i++) {
            System.out.println("num = " + num--);
        }
    }
}

class TheThread extends Thread {
    Example example;

    public TheThread(Example example) {
        this.example = example;
    }

    @Override
    public void run() {
        this.example.execute();
    }
}


