package com.example.springproject.service;

import com.example.springproject.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:
 */
@Service
public class UserService {

    public List<User> getAllUser() throws InterruptedException {
        Thread.sleep(500);
        List<User> userList = new ArrayList<>();
        userList.add(User.builder().name("小米").age(50).build());
        userList.add(User.builder().name("华为").age(100).build());
        userList.add(User.builder().name("阿里").age(70).build());
        return userList;
    }
}
