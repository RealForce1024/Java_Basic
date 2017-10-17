package com.fqc.suggest;

import java.util.Random;

/**
 * @author fqc
 * <p>
 * 要保证运行时常量不会改变。即在编译器就能确定常量值。不要随机序列数等额外的操作。
 */
public class Sug001Constant {
    public static final int CONST_NUMBER = 10000;

    public static void main(String[] args) {
        System.out.println(Const.RANDOM_NUM);
        System.out.println(CONST_NUMBER);
    }
}

interface Const {
    int RANDOM_NUM = new Random().nextInt();
}
