package com.fqc.samples;

/**
 * @author fqc
 */
public class TestInherit {
    public static void main(String[] args) {
        Base b = new Base();
        b.print();

        Base base = new Sub();
        base.print();

        Sub sub = new Sub();
        sub.print();
    }
}

class Base {
    public void print() {
        System.out.println("Base print");
    }
}

class Sub extends Base {
    @Override
    public void print() {
        System.out.println("Sub print");
    }
}
