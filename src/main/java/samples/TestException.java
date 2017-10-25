package samples;

/**
 * @author fqc
 */
public class TestException {
    public static void main(String[] args) {
        int a = 100;
        int b = 0;
        int c = 0;

        try {
            c = a / b;
        } catch (ArithmeticException e) {
            e.printStackTrace();
            throw e;
        }

        System.out.println(c);
        System.out.println("test");

    }
}
