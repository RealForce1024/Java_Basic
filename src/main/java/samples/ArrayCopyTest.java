package samples;

import java.util.Arrays;

/**
 * Created by fqc on 15/11/26.
 */

class Clothes extends Object{

    public Clothes() {
    }

    public Clothes(String color, String size) {
        this.color = color;
        this.size = size;
    }
    public String color;
    public String size;

}

public class ArrayCopyTest {
    public static void main(String[] args) {

        Clothes[] c1 = {new Clothes("red", "1"),new Clothes("red2", "2")};

        Arrays.copyOf(c1, c1.length);
        Clothes[] c2 = Arrays.copyOf(c1, c1.length);
        for (Clothes clothes : c2) {
            System.out.printf("color:%s, size: %s %n", clothes.color, clothes.size);
        }

        /*but it's deep?*/
        for (Clothes clothe : c1) {
            /*this way can't change anything*/
            clothe.color = "blue";
            clothe.size = "6";
        }

        for (int i = 0; i < c1.length; i++) {
            c1[i].color = "blue";
            c1[i].size = "8";
        }


        /*通过改变c1的值，发现c2的值也改变了，这就挺危险的事情，
         * 这是一种浅复制，实际上就是引用的复制 */
        for (Clothes clothes : c1) {
            System.out.printf("%s,%s%n",clothes.color,clothes.size);
        }

        for (Clothes clothes : c2) {
            System.out.printf("%s,%s%n",clothes.color,clothes.size);
        }





    }
}
