package samples;

import java.util.DoubleSummaryStatistics;

/**
 * Created by fqc on 15/11/4.
 */
public class TypeRange {
    public static void main(String[] args) {
        //byte short int long 的范围
        System.out.printf("%d~%d%n", Byte.MIN_VALUE, Byte.MAX_VALUE);
        System.out.printf("%d~%d%n", Short.MIN_VALUE, Short.MAX_VALUE);
        System.out.printf("%d~%d%n", Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.printf("%d~%d%n", Long.MIN_VALUE, Long.MAX_VALUE);
        System.out.printf("%d~%d%n", Byte.MIN_VALUE, Byte.MAX_VALUE);

        //float double 的精度范围
        System.out.printf("%d~%d%n", Float.MIN_EXPONENT, Float.MAX_EXPONENT);
        System.out.printf("%d~%d%n", Double.MAX_EXPONENT, Double.MAX_EXPONENT);

        //char可表示的Unicode 范围
        System.out.printf("%h~%h%n", Character.MIN_VALUE, Character.MAX_VALUE);

        //boolean的两个值
        System.out.printf("%b~%b%n", Boolean.FALSE, Boolean.TRUE);

        /*
        *
        -128~127
        -32768~32767
        -2147483648~2147483647
        -9223372036854775808~9223372036854775807
        -128~127
        -126~127
        1023~1023
        0~ffff
        false~true
        * */

    }
}
