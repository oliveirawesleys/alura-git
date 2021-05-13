package com.training.trainingproject.domain.repository;

import com.training.trainingproject.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByName(String name);
    List<User> findByNameContaining(String name);

}
