package com.training.trainingproject.domain.service;

import com.training.trainingproject.domain.exception.BusinessException;
import com.training.trainingproject.domain.model.OrderWork;
import com.training.trainingproject.domain.model.StatusOrderWork;
import com.training.trainingproject.domain.model.User;
import com.training.trainingproject.domain.repository.OrderWorkRepository;
import com.training.trainingproject.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Service
public class ManagementOrderWorkService {

    @Autowired
    private OrderWorkRepository orderWorkRepository;

    @Autowired
    private UserRepository userRepository;

    public OrderWork create(OrderWork orderWork) {
        User user = userRepository.findById(orderWork.getUser().getId())
                .orElseThrow(() -> new BusinessException("Cliente não encontrado"));
        orderWork.setUser(user);
        orderWork.setStatus(StatusOrderWork.OPEN);
        orderWork.setOpenDate(OffsetDateTime.now());

        return orderWorkRepository.save(orderWork);
    }
}
