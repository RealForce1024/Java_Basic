package samples;

import sun.swing.StringUIClientPropertyKey;

/**
 * samples
 *
 * @author fqc
 * @date 16/2/19
 */
public class Garbage {
    public static void main(String[] args) {
        System.out.println(""+'a'+1);

    }
}
class Test {
    int x, y;

    Test(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static void main(String[] args) {
        Test pt1, pt2;
        pt1 = new Test(3, 3);
        pt2 = new Test(4, 4);
        System.out.print(pt1.x + pt2.x);
    }
}


class Parent {
    int a = 3;
    Parent() {
        System.out.println("parent");
    }
}
 class Child extends Parent {
     int b;

    Child(String s) {
        super();//must be first stament in constructor body
        System.out.println(s);
        System.out.println(b);
        System.out.println(super.a);
//        super();//
    }


    public static void main(String[] args) {
        Child child = new Child("child");
    }
}
