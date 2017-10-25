package com.fqc.interview;

public class PrintConstructor {
    public static void main(String[] args) {
        new Son();
    }
}

class Father {
    private String name = "FATHER";

    public Father() {
        whoAmI();
        tellName(name);
    }

    public void whoAmI() {
        System.out.println("Father says, I am " + name);
    }

    public void tellName(String name) {
        System.out.println("Father's name is " + name);
    }
}

class Son extends Father {
    private String name = "SON";

    public Son() {
        whoAmI();
        tellName(name);
    }

    @Override
    public void whoAmI() {
        System.out.println("Son says, I am " + name);
    }

    @Override
    public void tellName(String name) {
        System.out.println("Son's name is " + name);
    }
}
