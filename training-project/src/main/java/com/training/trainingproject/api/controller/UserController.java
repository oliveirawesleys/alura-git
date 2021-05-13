package com.training.trainingproject.api.controller;

import com.training.trainingproject.domain.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.List;

@RestController
public class UserController {

    @PersistenceContext
    private EntityManager manager;

    @GetMapping("/users")
    public List<User> list() {
        return manager.createQuery("from User", User.class).getResultList();
    }
}
