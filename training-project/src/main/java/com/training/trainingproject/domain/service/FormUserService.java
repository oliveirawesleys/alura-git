package com.training.trainingproject.domain.service;

import com.training.trainingproject.domain.exception.BussinesException;
import com.training.trainingproject.domain.model.User;
import com.training.trainingproject.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormUserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        User userExist = userRepository.findByEmail(user.getEmail());

        if (userExist != null && !userExist.equals(user)) {
            throw new BussinesException("Já existe um cliente cadastrado com esse e-mail!");
        }
        return userRepository.save(user);
    }

    public void delete(Long userId) {
        userRepository.deleteById(userId);
    }
}
