package com.learning.spring.learning.domain.repository;

import com.learning.spring.learning.controller.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {
    List<User> findByName(String name);
    List<User> findByNameContaining(String name);
}
