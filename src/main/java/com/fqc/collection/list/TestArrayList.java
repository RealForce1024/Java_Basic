package com.fqc.collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by fqc on 2016/7/1.
 */
public class TestArrayList {
    public static void main(String[] args) {
        //testCreateArrayList();

    }

    private static void testCreateArrayList() {
        //1. 直接new ArrayLit()即可，生成的其实是可自动扩容的长度为0的空数组，但能够放置任何类型。
        ArrayList arrayList = new ArrayList();
        System.out.println(Arrays.toString(arrayList.toArray()));


        //2. list 与数组间的转换同时Arrays.asList()方法生成数组
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        Object[] objects = list.toArray();
        System.out.println("Arrays.asList Arrays.toString =>" + Arrays.toString(objects));

    }
}
