package base;

/**
 * @author:
 */
public class UserService {

    public String getName(String id) throws InterruptedException {
        Thread.sleep(3000);
        return "hello " + id;
    }
}
