package com.training.trainingproject.api.controller;

import com.training.trainingproject.domain.model.User;
import com.training.trainingproject.domain.repository.UserRepository;
import com.training.trainingproject.domain.service.FormUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

/*    @PersistenceContext
    private EntityManager manager;

    @GetMapping("/users")
    public List<User> list() {
        return manager.createQuery("from User", User.class).getResultList();
    }*/

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FormUserService userService;

    @GetMapping
    public List<User> list() {
        return userRepository.findAll();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> search(@PathVariable Long userId) {
        Optional<User> user = userRepository.findById(userId);

        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User add(@Valid @RequestBody User newUser) {
        return userService.saveUser(newUser);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId, @Valid @RequestBody User user) {

        if (!userRepository.existsById(userId)) {
            ResponseEntity.notFound().build();
        }
        user.setId(userId);
        user = userService.saveUser(user);

        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        if (!userRepository.existsById(userId)) {
            ResponseEntity.notFound().build();
        }

        userService.delete(userId);
        return ResponseEntity.noContent().build();
    }
}
