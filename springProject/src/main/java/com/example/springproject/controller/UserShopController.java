package com.example.springproject.controller;

import com.example.springproject.model.Shop;
import com.example.springproject.model.User;
import com.example.springproject.service.ShopService;
import com.example.springproject.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

/**
 * @author:
 */
@RestController
@RequestMapping("/userShop")
public class UserShopController {
    @Resource
    private UserService userService;
    @Resource
    private ShopService shopService;

    @GetMapping("/")
    public Map<String, Object> getAll() throws InterruptedException {
        Map<String, Object> map = new HashMap<>();
        map.put("user", userService.getAllUser());
        Thread.sleep(300);
        map.put("shop", shopService.getAllShop());
        return map;
    }

    @GetMapping("/q")
    public Map<String, Object> getAllThread() {

        Map<String, Object> map = new HashMap<>();
        try {

            CompletableFuture<List<User>> userT = CompletableFuture.supplyAsync(() -> {
                try {
                    return userService.getAllUser();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            Thread.sleep(300);
            CompletableFuture<List<Shop>> shopT = CompletableFuture.supplyAsync(() -> {
                try {
                    return shopService.getAllShop();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });

            map.put("user", userT.get(3, TimeUnit.SECONDS));
            map.put("shop", shopT.get(3, TimeUnit.SECONDS));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }

    @GetMapping("/p")
    public Map<String, Object> getAllThreadP() {

        Map<String, Object> map = new HashMap<>();
        try {

            CompletableFuture<List<User>> userT = CompletableFuture.supplyAsync(() -> {
                try {
                    return userService.getAllUser();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            Thread.sleep(300);
            CompletableFuture<List<Shop>> shopT = CompletableFuture.supplyAsync(() -> {
                try {
                    return shopService.getAllShop();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });

            map.put("user", userT.get(3, TimeUnit.SECONDS));
            map.put("shop", shopT.get(3, TimeUnit.SECONDS));

            CompletableFuture<Void> thenUserT = userT.thenAccept((e) -> {
                e.forEach(u -> System.out.println(u));
            });
            System.out.println(thenUserT.get());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }

    @GetMapping("/goShopping")
    public Map<String, Object> goShopping() {

        Map<String, Object> map = new HashMap<>();
        try {

            CompletableFuture<List<User>> userT = CompletableFuture.supplyAsync(() -> {
                try {
                    System.out.println("线程名称:" + Thread.currentThread().getName());
                    return userService.getAllUser();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            Thread.sleep(300);

            CompletableFuture<Void> userTT = userT.thenAcceptAsync((u) -> {
                System.out.println("线程名称:" + Thread.currentThread().getName());
                u.parallelStream().forEach(user -> System.out.println(user.getName()));
            });

            System.out.println(userTT.get());

            CompletableFuture<List<String>> userTTT = userT.thenApplyAsync((u) -> {
                System.out.println("线程名称:" + Thread.currentThread().getName());
                List<String> retList = new ArrayList<>();
                u.parallelStream().forEach(user -> retList.add(user.getName() + "去购物"));
                return retList;
            });

            System.out.println(userTTT.get());

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("线程名称:" + Thread.currentThread().getName());
        return map;
    }


    @GetMapping("/goShoppingE")
    public Map<String, Object> goShoppingE() {

        Map<String, Object> map = new HashMap<>();
        try {

            CompletableFuture<List<User>> userT = CompletableFuture.supplyAsync(() -> {
                try {
                    System.out.println("线程名称:" + Thread.currentThread().getName());
                    return userService.getAllUser();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            CompletableFuture<List<String>> userTS = userT.thenApplyAsync((u) -> {
                System.out.println("线程名称:" + Thread.currentThread().getName());
                List<String> retList = new ArrayList<>();
                u.parallelStream().forEach(user -> retList.add(user.getName() + "去购物"));
                int i = 1 / 0;
                return retList;
            });
            CompletableFuture<List<String>> exT = userTS.exceptionally((ex) -> {
                ex.printStackTrace();
                return Collections.singletonList("出现异常执行新逻辑");
            });
            Thread.sleep(300);

            System.out.println(exT.get());

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("线程名称:" + Thread.currentThread().getName());
        return map;
    }

    @GetMapping("/goShoppingC")
    public Map<String, Object> goShoppingC() {

        Map<String, Object> map = new HashMap<>();
        try {

            CompletableFuture<List<User>> userT = CompletableFuture.supplyAsync(() -> {
                try {
                    System.out.println("线程名称:" + Thread.currentThread().getName());
                    return userService.getAllUser();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            CompletableFuture<List<User>> userTS = userT.handle((u, throwable) -> {
                System.out.println("线程名称:" + Thread.currentThread().getName());
                System.out.println("上个任务的返回值:" + u);
                List<User> bu = new ArrayList<>();
                u.parallelStream().forEach(user -> {
                    user.setName("增赠曾" + user.getName());
                    bu.add(user);
                });
                return bu;
            });

            Thread.sleep(300);

            System.out.println(userTS.get());

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("线程名称:" + Thread.currentThread().getName());
        return map;
    }

    @GetMapping("/goShoppingCombine")
    public Map<String, Object> goShoppingCombine() {

        Map<String, Object> map = new HashMap<>();
        try {

            CompletableFuture<List<User>> userT = CompletableFuture.supplyAsync(() -> {
                try {
                    System.out.println("线程名称:" + Thread.currentThread().getName());
                    return userService.getAllUser();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            Thread.sleep(300);
            CompletableFuture<List<Shop>> shopT = CompletableFuture.supplyAsync(() -> {
                try {
                    System.out.println("线程名称:" + Thread.currentThread().getName());
                    return shopService.getAllShop();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });

            CompletableFuture<Void> future = shopT.thenAcceptBothAsync(userT, (s, u) -> {
                System.out.println("线程名称:" + Thread.currentThread().getName());
                System.out.println( u.parallelStream().map(User::getName).findAny().get() +
                        " 逛 "
                        + s.parallelStream().map(Shop::getName).findAny().get());
            });

            System.out.println(future.join());
            map.put("res", future.join());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("线程名称:" + Thread.currentThread().getName());
        return map;
    }

}
