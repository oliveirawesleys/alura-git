package com.training.trainingproject.api.controller;

import com.training.trainingproject.domain.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class UserController {

    @GetMapping("/users")
    public List<User> list() {

        var user1 = new User();
        user1.setId(1l);
        user1.setName("Batman");
        user1.setPhone("991");
        user1.setEmail("batman@begins.com");

        var user2 = new User();
        user1.setId(2l);
        user1.setName("Robin");
        user1.setPhone("991 option 2");
        user1.setEmail("callbatman@begins.com");

        return Arrays.asList(user1, user2);
    }
}
