package com.learning.spring.orders.domain.service;

import com.learning.spring.orders.domain.exception.BusinessException;
import com.learning.spring.orders.domain.model.Client;
import com.learning.spring.orders.domain.model.OrderService;
import com.learning.spring.orders.domain.model.StatusOrderService;
import com.learning.spring.orders.domain.repository.ClienteRepository;
import com.learning.spring.orders.domain.repository.OrderServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Service
public class ManagerOrderService {

    @Autowired
    private OrderServiceRepository orderServiceRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public OrderService create(OrderService orderService) {
        Client client = clienteRepository.findById(orderService.getClient().getId())
                .orElseThrow(() -> new BusinessException("Cliente não encontrado."));

        orderService.setClient(client);
        orderService.setStatus(StatusOrderService.OPEN);
        orderService.setDateStart(OffsetDateTime.now());

        return orderServiceRepository.save(orderService);
    }

}
