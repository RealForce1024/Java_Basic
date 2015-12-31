package samples;

import java.util.Random;
import java.util.Scanner;


/**
 * Created by fqc on 2015/11/3.
 */
public class GuessNumber {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int random_num = (int) (Math.random()*10);
//        int guess_num = 0;
//
//        do {
//            System.out.println("Please input one num of [0~9] ");
//            guess_num = scanner.nextInt();
//            System.out.println("guess_num = " + guess_num);
//            System.out.println("random_num = " + random_num);
//        }while(random_num != guess_num);
        guessNumber();
    }


    private static void guessNumber() {
        int guessNum;
        int randomNum;
        do {
            System.out.println("请输入您心中的数");
            guessNum = new Scanner(System.in).nextInt();
            randomNum = (int)(Math.random()*10);//random 随机数0.xxxxx.~1
            System.out.println("猜数:"+guessNum+"随机数:"+randomNum);
        } while (guessNum!=randomNum);
    }



}
