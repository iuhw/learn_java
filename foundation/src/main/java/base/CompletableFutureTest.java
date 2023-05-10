package base;

import java.util.concurrent.CompletableFuture;

/**
 * @author:
 */
public class CompletableFutureTest {
    public static void main(String[] args) throws Exception {

        long startTime = System.currentTimeMillis();

        UserService userService = new UserService();
        LearnService learnService = new LearnService();

        CompletableFuture<String> userFuture = CompletableFuture.supplyAsync(() -> {
            try {
                return userService.getName("555");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        CompletableFuture<String> learnFuture = CompletableFuture.supplyAsync(() -> {
            try {
                return learnService.learn("java");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        String userRes = userFuture.get();
        String learnRes = learnFuture.get();

        System.out.println(userRes + "_" + learnRes);

        System.out.println("耗时" + (System.currentTimeMillis() - startTime));

    }
}
