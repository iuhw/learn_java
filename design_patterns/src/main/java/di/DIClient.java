package di;

/**
 * @author:
 */
public class DIClient {
    public static void main(String[] args) {
        IDriver zhangsan = new Driver();
        ICar benz = new Benz();
        zhangsan.driver(benz);
    }
}
