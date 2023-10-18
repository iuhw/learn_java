package com.example.springproject;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author:
 */
public class CompletableFutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        CompletableFuture<String> first = CompletableFuture.supplyAsync(() -> {
            System.out.println("第一个任务执行");
//            int i = 1 / 0;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "first";
        });

        CompletableFuture<String> sec = CompletableFuture.supplyAsync(() -> {
            System.out.println("第二个任务执行");
            return "second";
        });

        CompletableFuture<String> allOf = CompletableFuture.allOf(first, sec).handle((m, k) -> {
            try {
                System.out.println(first.get(1,TimeUnit.SECONDS) + "---");
                System.out.println(sec.get(1,TimeUnit.SECONDS) + "$$$");
                System.out.println("m=" + m);
                System.out.println("k=" + k);
                System.out.println("任务都执行完了");
                Thread.sleep(11100);
                return first.get() + sec.get();
            } catch (InterruptedException | ExecutionException | TimeoutException e) {
                throw new RuntimeException(e);
            }
        }).exceptionally((ex) -> "发生错误" + ex.getMessage());

        System.out.println(allOf.get(1, TimeUnit.SECONDS));
    }
}
