package com.fqc.jdk8;

import java.util.Arrays;

public class test05 {
    public static void main(String[] args) {
        Arrays.stream((new int[]{1, 2, 3, 4, 5})).reduce( (x, y) -> x + y).ifPresent(System.out::println);
        System.out.println(Arrays.stream((new int[]{1, 2, 3, 4, 5})).reduce(0, (x, y) -> x + y));
    }
}
