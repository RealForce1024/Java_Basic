package com.fqc.interview;

/**
 * @author fqc
 */
public class Test {
    static {
        System.out.println("hello world");
    }

    public static void main(String[] args) {
        int a = 23;
        // byte b = 128;
        byte b = 127;
        // b = a; //will be compile wrong,because it should be convert by force
        System.out.println("hello main");
    }
}