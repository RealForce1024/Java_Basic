package com.fqc.jdk8;

import java.util.Arrays;

public class test03 {
    public static void main(String[] args) {
        //编译器会自动上下文推断类型.且可以控制输出的角标范围(过滤手段之一)
        Arrays.stream((new int[]{1, 2, 3, 4})).forEach(System.out::println);
        Arrays.stream((new double[]{1, 2, 3.0, 4.1}), 2, 4).forEach(System.out::println);

        //filter 过滤 例如:只打印集合中偶数
        Arrays.stream((new int[]{1, 2, 3, 4})).filter(x -> x % 2 == 0).forEach(System.out::println);
    }
}
