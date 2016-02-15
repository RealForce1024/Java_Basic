package samples;

/**
 * samples
 *
 * @author fqc
 * @date 16/2/14
 */
public class Sweet { //编码小技巧
    public static void main(String[] args) {
        testTernaryOperator();
    }
    //三元运算符
    public static void testTernaryOperator() {
        int a = 8;
        System.out.printf("%d是偶数吗%n:%s", a, (a / 2 == 0 ? '是' : '否'));
    }
    //短路与或非
    public static void testAndOrNot() {
        int a = 0;
        if (a != 0 && 5/a==2) { //避免a为0的异常技巧
            System.out.println(a);
        }
    }


//    与：有0得0
//    或：有1得1
//    异或：相同得0，不同得1。



}
