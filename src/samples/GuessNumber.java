package samples;

import java.util.Scanner;


/**
 * Created by fqc on 2015/11/3.
 */
public class GuessNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int random_num = (int) (Math.random()*10);
        int guess_num = 0;

        do {
            System.out.println("Please input one num of [0~9] ");
            guess_num = scanner.nextInt();
            System.out.println("guess_num = " + guess_num);
            System.out.println("random_num = " + random_num);
        }while(random_num != guess_num);
    }




}
