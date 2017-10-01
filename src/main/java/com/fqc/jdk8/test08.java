package com.fqc.jdk8;

import java.util.OptionalDouble;

public class test08 {
    public static OptionalDouble calc(double a, double b) {
        OptionalDouble result = null;
        if (b == 0) {
            return OptionalDouble.empty();
        }
        return result.of(a / b);
    }

    public static void main(String[] args) {
        calc(1.0,0).ifPresent(System.out::println);
    }
}
