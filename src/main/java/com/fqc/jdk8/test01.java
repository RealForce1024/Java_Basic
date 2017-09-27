package com.fqc.jdk8;

import java.util.Arrays;

public class test01 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        //对数组元素为奇数的进行+1操作

        //传统方式 可变性
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                arr[i]++;
            }
        }
        System.out.println(Arrays.toString(arr));//原数组已经被修改

        //java8方式 不可变性
        int[] brr = {9, 8, 7, 6, 5};
        Arrays.stream(brr).map(x -> x % 2 == 0 ? x : x + 1).forEach(System.out::println);
        System.out.println("-------------");
        Arrays.stream(brr).filter(x -> x % 2 == 0).forEach(System.out::println);
    }
}
