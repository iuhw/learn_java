package com.example.springproject.service;

import com.example.springproject.model.Shop;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:
 */
@Service
public class ShopService {

    public List<Shop> getAllShop() throws InterruptedException {
        Thread.sleep(700);

        List<Shop> shopList = new ArrayList<>();
        shopList.add(Shop.builder().no("001").name("沃尔玛").build());
        shopList.add(Shop.builder().no("101").name("家乐福").build());
        shopList.add(Shop.builder().no("201").name("华联").build());

        return shopList;
    }

}
