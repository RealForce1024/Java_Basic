package com.fqc.array;

import sun.text.resources.cldr.rm.FormatData_rm;

import java.util.Arrays;

/**
 * Created by fqc on 2016/6/30.
 */
public class TestArray {


    public static void main(String[] args) {

        //testCreateArray();
        testMethodOfArray();

    }

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
            System.out.println("arrs.for:遍历"+arr);
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
