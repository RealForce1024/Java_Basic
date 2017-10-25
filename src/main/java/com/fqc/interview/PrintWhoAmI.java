package com.fqc.interview;

/**
 * @author fqc
 */
public class PrintWhoAmI {
    public static void main(String[] args) {
        A a = new B();
        test(a); // please print result
    }

    public static void test(A a) {
        System.out.println("test A");
        a.whoAmI();
    }

    public static void test(B b) {
        System.out.println("test B");
        b.whoAmI();
    }
}

class A {
    public void whoAmI() {
        System.out.println("I'm A");
    }
}

class B extends A {
    @Override
    public void whoAmI() {
        System.out.println("I'm B");
    }
}
