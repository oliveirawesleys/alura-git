package com.training.trainingproject.api.controller;

import com.training.trainingproject.domain.model.OrderWork;
import com.training.trainingproject.domain.service.ManagementOrderWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/order-work")
public class OrderWorkController {

    @Autowired
    private ManagementOrderWorkService managementOrderWorkService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderWork create(@Valid @RequestBody OrderWork orderWork) {
        return managementOrderWorkService.create(orderWork);
    }
}
