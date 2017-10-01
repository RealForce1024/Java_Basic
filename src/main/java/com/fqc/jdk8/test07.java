package com.fqc.jdk8;

import java.util.Arrays;

public class test07 {
    public static void main(String[] args) {
        long count = Arrays.stream((new int[]{1, 2, 3, 4, 5})).filter(x -> x % 2 == 0).peek(System.out::println).count();
        System.out.println(count);
    }
}
