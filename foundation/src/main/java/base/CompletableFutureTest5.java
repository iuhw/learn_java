package base;

import java.security.spec.RSAOtherPrimeInfo;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author:
 */
public class CompletableFutureTest5 {
    public static void main(String[] args) throws Exception {
//
//        long startTime = System.currentTimeMillis();
////        ExecutorService executor = Executors.newFixedThreadPool(10);
////        Integer total = CompletableFuture.supplyAsync(() -> {
////            System.out.println(Thread.currentThread().getName());
////            int sum = 0;
////            for (int i = 0; i < 5000000; i++) {
////                sum += i;
////            }
////            return sum;
////        },executor).thenCombine(CompletableFuture.supplyAsync(() -> {
////            System.out.println(Thread.currentThread().getName());
////            int sum = 0;
////            for (int i = 5000000; i < 50000000; i++) {
////                sum += i;
////            }
////            return sum;
////        },executor), (s1, s2) -> s1 + s2).join();
//
//        int total = 0;
//        for (int i = 0; i < 50000000; i++) {
//            total += i;
//        }
//
//        System.out.println(total);
////        executor.shutdown();
//        System.out.println("耗时" + (System.currentTimeMillis() - startTime));


        System.out.println(LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8")));
    }
}
