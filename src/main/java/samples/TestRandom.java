package samples;

/**
 * samples
 *
 * @author fqc
 * @date 16/2/23
 */

import java.util.Random;

class TestRandom {
    public static void main(String[] args) {
        // Random random1 = new Random(100);
        Random random1 = new Random();
        System.out.println(random1.nextInt());
        System.out.println(random1.nextFloat());
        System.out.println(random1.nextBoolean());

        // Random random2 = new Random(100);
        //默认是只用了当前系统的时间戳，random seed肯定不同了。
        Random random2 = new Random();
        System.out.println(random2.nextInt());
        System.out.println(random2.nextFloat());
        System.out.println(random2.nextBoolean());


        double random = Math.random();
        System.out.println(random);
    }
}