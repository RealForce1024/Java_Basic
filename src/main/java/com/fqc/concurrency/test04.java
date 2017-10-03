package com.fqc.concurrency;

public class test04 {
    public static void main(String[] args) {
        DirtyRead dr = new DirtyRead();
        dr.getValue();
        new Thread(() -> dr.setValue()).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        dr.getValue();// 主线程需要同步访问才能避免脏读
    }
}

class DirtyRead {
    private String username;
    private int password;

    public synchronized void setValue() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        username = "username";
        password = 123456;
    }

    //public  void getValue() {
    public synchronized void getValue() { // fix
        System.out.println("username:" + username + " password:" + password);
    }
}


