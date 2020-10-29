package com.learning.spring.learning.domain.service;

import com.learning.spring.learning.domain.exception.BusinessException;
import com.learning.spring.learning.domain.exception.EntityNotFoundException;
import com.learning.spring.learning.domain.model.Comment;
import com.learning.spring.learning.domain.model.OrderService;
import com.learning.spring.learning.domain.model.StatusOrderService;
import com.learning.spring.learning.domain.model.User;
import com.learning.spring.learning.domain.repository.CommentRepository;
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

    @Autowired
    private CommentRepository commentRepository;

    public OrderService create(OrderService order) {
        User user = userRepository.findById(order.getUser().getId())
                .orElseThrow(() -> new BusinessException("Cliente não encontrado."));

        order.setUser(user);
        order.setStatus(StatusOrderService.ABERTA);
        order.setDateStart(OffsetDateTime.now());

        return orderServiceRepository.save(order);
    }

    public Comment addComment(Long orderServiceId, String description) {
        OrderService orderService = find(orderServiceId);

        Comment comment = new Comment();
        comment.setDateSend(OffsetDateTime.now());
        comment.setDescription(description);
        comment.setOrderService(orderService);

        return commentRepository.save(comment);
    }

    public void finishOrderService(Long orderServiceId) {
        OrderService orderService = find(orderServiceId);

        orderService.finish();

        orderServiceRepository.save(orderService);
    }

    private OrderService find(Long orderServiceId) {
        return orderServiceRepository.findById(orderServiceId)
                .orElseThrow(() -> new EntityNotFoundException("Ordem de serviço não encontrada."));
    }

}
