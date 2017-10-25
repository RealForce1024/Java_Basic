package samples;

import java.util.Arrays;

/**
 * @author fqc
 */
public class TestString {
    public static void main(String[] args) {
        String a = "a";
        System.out.println(a.hashCode());
        a = "b";
        String b = a;
        System.out.println(a == b);

        String str = "中国";
        byte[] bytes = str.getBytes();
        System.out.println(new String(bytes));

        int[] arr = new int[10];
        System.out.println(arr.length);
        int[] arr2 = expendArrayLength(arr, 20);
        System.out.println(arr2.length);

        int aa = 100;
        Integer.valueOf(aa);
        Integer bb = new Integer(100);
        bb.intValue();



    }

    public static int[] expendArrayLength(int[] arr, int newLength) {
        newLength = newLength < 0 ? 0 : newLength;
        return Arrays.copyOf(arr, newLength);
    }

}
