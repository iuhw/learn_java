package base;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author:
 */
public class CompletableFutureTest1 {
    public static void main(String[] args) throws Exception {

        long startTime = System.currentTimeMillis();

        ExecutorService executor = Executors.newCachedThreadPool();

        CompletableFuture<Void> runFuture = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("第一个任务");
        }, executor);

        CompletableFuture<String> supplyFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("第二个任务");
            return "第二任务";
        }, executor);

        System.out.println(runFuture.join());
        System.out.println(supplyFuture.join());

        executor.shutdown();

        System.out.println("耗时" + (System.currentTimeMillis() - startTime));

    }
}
