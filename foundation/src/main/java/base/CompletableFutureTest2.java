package base;

import java.util.concurrent.CompletableFuture;

/**
 * @author:
 */
public class CompletableFutureTest2 {
    public static void main(String[] args) throws Exception {

        CompletableFuture<String> orgFuture = CompletableFuture.supplyAsync(
                ()->{
                    System.out.println("先执行第一个CompletableFuture方法任务");
                    return "捡田螺的小男孩";
                }
        );

        CompletableFuture thenRunFuture = orgFuture.thenRun(() -> {
            System.out.println("接着执行第二个任务");
        });

        System.out.println(thenRunFuture.get());
        System.out.println(orgFuture.get());

    }
}
