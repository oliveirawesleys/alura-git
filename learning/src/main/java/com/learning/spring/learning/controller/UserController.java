package com.learning.spring.learning.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class UserController {

    @GetMapping("/users")
    public List<User> listUser() {
        var user1 = new User();
        user1.setId(1L);
        user1.setName("Jhon");
        user1.setEmail("jhon@email.com");
        user1.setPhone("45459944");
        var user2 = new User();
        user2.setId(2L);
        user2.setName("Marie");
        user2.setEmail("Marie@email.com");
        user2.setPhone("66553321");

        return Arrays.asList(user1, user2);
    }
}
