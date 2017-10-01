package com.fqc.jdk8;

import java.util.Arrays;

public class test09 {
    public static void main(String[] args) {
        System.out.println(Arrays.stream((new int[]{1, 3, 5})).average());
        Arrays.stream((new int[]{1, 3, 0})).average().ifPresent(System.out::println);
    }
}


