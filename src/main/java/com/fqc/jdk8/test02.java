package com.fqc.jdk8;

import java.util.Arrays;
import java.util.function.IntConsumer;

public class test02 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        IntConsumer outPrint = System.out::println;
        IntConsumer errPrint = System.err::println;
        Arrays.stream(arr).forEach(outPrint.andThen(errPrint));
    }
}




