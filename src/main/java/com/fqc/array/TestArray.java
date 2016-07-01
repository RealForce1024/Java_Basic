package com.fqc.array;

import sun.text.resources.cldr.rm.FormatData_rm;

import java.util.Arrays;
import java.util.List;

/**
 * Created by fqc on 2016/6/30.
 */
public class TestArray {


    public static void main(String[] args) {

        //testCreateArray();
        //testMethodOfArray();
        testMethodOfArrays();
    }


    private static void testMethodOfArrays() {
        //list 与数组间的转换 asList
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        Object[] objects = list.toArray();
        System.out.println("Arrays.asList Arrays.toString =>" + Arrays.toString(objects));

        //toString 见Arrays.toString()重写数组的的toString方法
        //sort
        int[] arrs = {3, 2, 5, 6, 3, 2, 1};
        Arrays.sort(arrs);
        System.out.println("Arrays.toStort=>" + Arrays.toString(arrs));
        //copy
        int[] newArrs = Arrays.copyOf(arrs, 3);
        System.out.println("Arrays.copy =>" + Arrays.toString(newArrs));

        //binarySearch
        // Searches the specified array of ints for the specified value using the binary search algorithm.
        // The array must be sorted (as by the sort(int[]) method) prior to making this call.
        // If it is not sorted, the results are undefined.
        // If the array contains multiple elements with the specified value,
        // there is no guarantee which one will be found.
        int i = Arrays.binarySearch(arrs,2);// now last step the arrs has been sorted  [1, 2, 2, 3, 3, 5, 6]
        System.out.println(i);

    }

    /**
     * 数组长度属性及遍历
     */
    private static void testMethodOfArray() {
        int[] arrs = {1, 32, 43, 4, 2, 0, 2};
        //数组长度 为属性
        System.out.println("数组的长度" + arrs.length);
        //数组的遍历
        for (int i = 0; i < arrs.length; i++) {
            System.out.println("arrs.fori：遍历" + arrs[i]);
        }
        for (int i = arrs.length - 1; i >= 0; i--) {
            System.out.println("arrs.forr:遍历" + arrs[i]);
        }
        for (int arr : arrs) {
            System.out.println("arrs.for:遍历" + arr);
        }
    }


    /**
     * 数组生成的三种方式
     */
    public static void testCreateArray() {
        /***给出元素数，就不要给确定的元素了*************/

        /***1.不知道具体元素的时候，只是当做容器*************/
        int[] array = new int[10];
        System.out.println(array);
        System.out.println(Arrays.toString(array));

        /***2.有了容器并已经装有元素了*************/
        int[] array2 = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(array2));

        /***3.最直接了当的 直接装元素*********************/
        int[] array3 = {1, 2, 3};

    }
}
