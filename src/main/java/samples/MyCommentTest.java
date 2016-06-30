package samples;


import javax.sound.midi.Soundbank;
import java.lang.reflect.Array;
import java.util.*;

/**
 * samples
 *
 * @author fqc
 * @date 15/12/31
 */
public class MyCommentTest {


    public static void insertSort(int count) {

        Integer[] a = {3, 6, 4, 2, 11, 10, 5};  // 注意int型

        int temp = 0;
        int count_ = 0;

        for (int i = 1; i < a.length; i++) {

            int j = i - 1;//i=j+1...

            temp = a[i];

            for (; j >= 0 && temp < a[j];j--) {

                a[j + 1] = a[j];                       //将大于temp的值整体后移一个单位
            }
            a[j + 1] = temp;

            printArray(a);

            System.out.println();

            if (count < a.length && count > 0 && ++count_ == count) break; //指定次数查看排序情况

        }
    }


    public static void main(String[] args) {
        insertSort(4);

    }

    public static void printArray(Object[] objects) { //int[] Integer[]
        for (Object object : objects) {
            System.out.println(object);
        }
    }




}
