package com.fqc.jdk8;

import java.util.Arrays;

public class test04 {
    public static void main(String[] args) {
        //映射操作
        Arrays.stream((new int[]{1, 2, 3, 4})).map(x -> x * 2).forEach(System.out::println);

        System.out.println("==============");
        //流式api 过滤和映射操作
        Arrays.stream((new int[]{5, 6, 7, 8})).filter(x -> x % 2 == 0).map(x -> x * x).forEach(System.out::println);
    }
}
