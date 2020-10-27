package com.learning.spring.learning.domain.service;

import com.learning.spring.learning.controller.User;
import com.learning.spring.learning.domain.exception.BusinessException;
import com.learning.spring.learning.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserService {

    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        User existUser = userRepository.findByEmail(user.getEmail());
        if (existUser != null && !existUser.equals(user)) {
            throw new BusinessException("Já existe um cliente com este e-mail.");
        }

        return userRepository.save(user);
    }

    public void exclude(Long id) {
        userRepository.deleteById(id);
    }
}
