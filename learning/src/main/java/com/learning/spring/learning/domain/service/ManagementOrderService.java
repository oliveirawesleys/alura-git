package com.learning.spring.learning.domain.service;

import com.learning.spring.learning.domain.exception.BusinessException;
import com.learning.spring.learning.domain.model.OrderService;
import com.learning.spring.learning.domain.model.StatusOrderService;
import com.learning.spring.learning.domain.model.User;
import com.learning.spring.learning.domain.repository.OrderServiceRepository;
import com.learning.spring.learning.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Service
public class ManagementOrderService {

    @Autowired
    private OrderServiceRepository orderServiceRepository;

    @Autowired
    private UserRepository userRepository;

    public OrderService create(OrderService order) {
        User user = userRepository.findById(order.getUser().getId())
                .orElseThrow(() -> new BusinessException("Cliente não encontrado"));

        order.setUser(user);
        order.setStatus(StatusOrderService.ABERTA);
        order.setDateStart(OffsetDateTime.now());

        return orderServiceRepository.save(order);
    }
}
