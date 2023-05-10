package base;

/**
 * @author:
 */
public class CompletableFutureTest3 {
    public static void main(String[] args) throws Exception {

        long startTime = System.currentTimeMillis();

        UserService userService = new UserService();
        LearnService learnService = new LearnService();

        System.out.println(userService.getName("345 "));
        System.out.println(learnService.learn(" Java"));

        System.out.println("耗时" + (System.currentTimeMillis() - startTime));

    }
}
