package base;

/**
 * @author:
 */
public class LearnService {

    public String learn(String name) throws InterruptedException {
        Thread.sleep(1000);
        return "learn" + name;
    }
}
