package samples;

import java.util.ArrayList;

/**
 * @author fqc
 */
public class TestArray {
    public static void main(String[] args) {

        ArrayList<Object> listA = new ArrayList<>();
        listA.add("A");
        listA.add("B");
        listA.add("B");
        System.out.println(listA);

        ArrayList<Object> listB = new ArrayList<>();
        listB.add("C");
        listB.add("B");
        listB.add("A");
        System.out.println(listB);

        listA.retainAll(listB);
        System.out.println(listA);
    }
}
