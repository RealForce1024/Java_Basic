package com.fqc.utils;

public class UserSrviceImpl {

    public void getUser() {
        try {
            //执行太快，延时一下
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
}
