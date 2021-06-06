package com.training.trainingproject.domain.service;

import com.training.trainingproject.api.model.Commentary;
import com.training.trainingproject.domain.exception.BusinessException;
import com.training.trainingproject.domain.exception.EntityNotFoundException;
import com.training.trainingproject.domain.model.OrderWork;
import com.training.trainingproject.domain.model.StatusOrderWork;
import com.training.trainingproject.domain.model.User;
import com.training.trainingproject.domain.repository.CommentaryRepository;
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

    @Autowired
    private CommentaryRepository commentaryRepository;

    public OrderWork create(OrderWork orderWork) {
        User user = userRepository.findById(orderWork.getUser().getId())
                .orElseThrow(() -> new BusinessException("Cliente não encontrado"));
        orderWork.setUser(user);
        orderWork.setStatus(StatusOrderWork.OPEN);
        orderWork.setOpenDate(OffsetDateTime.now());

        return orderWorkRepository.save(orderWork);
    }

    public Commentary addCommentary(Long orderWorkId, String description) {
        OrderWork orderWork = orderWorkRepository.findById(orderWorkId)
                .orElseThrow(() -> new EntityNotFoundException("Ordem de serviço não encontrada"));

        Commentary commentary = new Commentary();
        commentary.setDateSend(OffsetDateTime.now());
        commentary.setDescription(description);
        commentary.setOrderWork(orderWork);

        return commentaryRepository.save(commentary);
    }
}
