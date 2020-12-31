package com.learning.spring.orders.domain.service;

import com.learning.spring.orders.domain.exception.EntityNotFoundException;
import com.learning.spring.orders.api.model.Comment;
import com.learning.spring.orders.domain.exception.BusinessException;
import com.learning.spring.orders.domain.model.Client;
import com.learning.spring.orders.domain.model.OrderService;
import com.learning.spring.orders.domain.model.StatusOrderService;
import com.learning.spring.orders.domain.repository.ClienteRepository;
import com.learning.spring.orders.domain.repository.CommentRepository;
import com.learning.spring.orders.domain.repository.OrderServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public class ManagerOrderService {

    @Autowired
    private OrderServiceRepository orderServiceRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private CommentRepository commentRepository;

    public OrderService create(OrderService orderService) {
        Client client = clienteRepository.findById(orderService.getClient().getId())
                .orElseThrow(() -> new BusinessException("Cliente não encontrado."));

        orderService.setClient(client);
        orderService.setStatus(StatusOrderService.OPEN);
        orderService.setDateStart(OffsetDateTime.now());

        return orderServiceRepository.save(orderService);
    }

    public Comment addComment(Long orderServiceId, String description) {
        OrderService orderService = find(orderServiceId);

        Comment comment = new Comment();
        comment.setDateSend(OffsetDateTime.now());
        comment.setDescription(description);
        comment.setOrderService(orderService);

        return commentRepository.save(comment);
    }

    public void finishOrder(Long orderServiceId) {
        OrderService orderService = find(orderServiceId);

        orderService.finish();

        orderServiceRepository.save(orderService);
    }

    private OrderService find(Long orderServiceId) {
        return orderServiceRepository.findById(orderServiceId)
                .orElseThrow(() -> new EntityNotFoundException("Orderm de serviço não entrada."));
    }

}
