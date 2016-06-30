package samples;

import java.util.Arrays;

/**
 * samples
 *
 * @author fqc
 * @date 16/2/18
 */
public class InsertSort {
   /**
    *插入排序算法是一个对少量元素进行排序的有效算法。插入排序的工作原理与打牌时整理手中的牌的做法类似，开始摸牌时，我们的左手是空的，接着一次从桌上摸起一张牌，并将它插入到左手的正确位置。为了找到这张牌的正确位置，要将它与手中已有的牌从右到左进行比较，无论什么时候手中的牌都是排序好的。
    insertSort在数组A={5,2,4,6,1,3}上的处理过程，数组的下标出现在巨型的上方，黑色框的值即为key=a[j]。
    a[i]即为a[j]左边的值，每次循环key与a[i]进行比较，如果key<a[i],则a[i]移到 i+1处，同时i--向左移动，直到找到a[i]<=key或者i<0,此时将 key插入到a[i+1]处。
            问题1：a[i]第一次进行右移时覆盖了a[i+1]值，是否造成了数据丢失？
	    	答：不会造成数据丢失，应为第一次右移前的i+1=j，此时a[j]的值存在了key里了。每次右移都为下一次右移或插入留出了位置，这就是插入排序的关键点所在。
    *
    */

    public static void main(String[] args) {
        System.out.println(Arrays.toString(insertSort2(new int[]{1, 3, 2, 4, 8, 6, 5, 0})));
    }

    public static int[] insertSort(int a[]){
        int length=a.length; //数组长度
        int j;               //当前值的位置
        int i;               //指向j前的位置
        int key;             //当前要进行插入排序的值
        //从数组的第二个位置开始遍历值
        for(j=1;j<length;j++){
            key=a[j];
            i=j-1;
            //a[i]比当前值大时，a[i]后移一位,空出i的位置，好让下一次循环的值后移
            while(i>=0 && a[i]>key){
                a[i+1]=a[i]; //将a[i]值后移
                i--;         //i前移
            }//跳出循环(找到要插入的中间位置或已遍历到0下标)
            a[i+1]=key;    //将当前值插入
        }
//        for (int i1 : a) {
//            System.out.print(i1);
//        }
        return a;

    }


    public static int[] insertSort2(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            for (int j = i - 1; j >= 0 && temp < array[j]; j--) {
                array[j + 1] = array[j];
                array[j] = temp;
            }
        }
        return array;
    }

}
