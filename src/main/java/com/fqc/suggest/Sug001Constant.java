package com.fqc.suggest;

import java.util.Random;

/**
 * @author fqc
 */
public class Sug001Constant {
    public static final int CONST_NUMBER = 10000;

    public static void main(String[] args) {
        System.out.println(Const.RANDOM_NUMBER);
        System.out.println(CONST_NUMBER);
    }
}

interface Const {
    int RANDOM_NUMBER = new Random().nextInt();
}