package singleton;

/**
 * @author:
 */
public class SingletonTest {
    private static final SingletonTest singleton = new SingletonTest();
    private SingletonTest(){}
    public static SingletonTest getInstance(){
        return singleton;
    }

    public void doSomething(){
        System.out.println("做点啥");
    }

}
