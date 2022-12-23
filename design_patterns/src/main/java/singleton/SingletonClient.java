package singleton;

/**
 * @author:
 */
public class SingletonClient {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            SingletonTest test = SingletonTest.getInstance();
            System.out.println(test);
            test.doSomething();
        }
    }
}
