package com.api.wesley.simple.apisimple.repository;

import com.api.wesley.simple.apisimple.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
