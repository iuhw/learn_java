package base;

import java.util.concurrent.CompletableFuture;

/**
 * @author:
 */
public class CompletableFutureTest4 {
    public static void main(String[] args) throws Exception {

        long startTime = System.currentTimeMillis();

        UserService userService = new UserService();
        LearnService learnService = new LearnService();

        CompletableFuture<String> userFuture = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println(Thread.currentThread().getName());
                return userService.getName("555");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println(userFuture.get());
        CompletableFuture<String> learnFuture = userFuture.thenApply((r) -> {
            try {
                System.out.println(Thread.currentThread().getName());
                System.out.println(learnService.learn("java") + " ");
                return "l" + r;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println(learnFuture.get());
        System.out.println("耗时" + (System.currentTimeMillis() - startTime));

    }
}
