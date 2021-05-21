package com.training.trainingproject.domain.service;

import com.training.trainingproject.domain.model.OrderWork;
import com.training.trainingproject.domain.model.StatusOrderWork;
import com.training.trainingproject.domain.repository.OrderWorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ManagementOrderWorkService {

    @Autowired
    private OrderWorkRepository orderWorkRepository;

    public OrderWork create(OrderWork orderWork) {
        orderWork.setStatus(StatusOrderWork.OPEN);
        orderWork.setOpenDate(LocalDateTime.now());

        return orderWorkRepository.save(orderWork);
    }
}
