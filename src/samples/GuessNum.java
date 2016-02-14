package samples;

import java.util.Scanner;

/**
 * samples
 *
 * @author fqc
 * @date 16/2/14
 */
public class GuessNum {
    public static void main(String[] args) {
        Guess();
    }

    private static void Guess() {
        int random; //局部变量 未被初始化
        int guessNum ;
        do {
            System.out.println("请输入您心中的数字：");
            guessNum = new Scanner(System.in).nextInt();
            random = (int) (Math.random() * 10);
            System.out.println(String.format("随机数:%d,猜数:%d",random,guessNum));

        } while (random!=guessNum);
    }

}
