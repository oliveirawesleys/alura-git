package com.learning.spring.learning.controller;

import com.learning.spring.learning.domain.model.OrderService;
import com.learning.spring.learning.domain.repository.OrderServiceRepository;
import com.learning.spring.learning.domain.service.ManagementOrderService;
import com.learning.spring.learning.model.OrderServiceModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order-service")
public class OrderServiceController {

    @Autowired
    private ManagementOrderService managementOrderService;

    @Autowired
    private OrderServiceRepository orderServiceRepository;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderService create(@Valid @RequestBody OrderService order) {
        return managementOrderService.create(order);
    }

    @GetMapping
    public List<OrderService> list() {
        return orderServiceRepository.findAll();
    }

    @GetMapping("/{orderServiceId}")
    public ResponseEntity<OrderServiceModel> search(@PathVariable Long orderServiceId) {
        Optional<OrderService> orderService = orderServiceRepository.findById(orderServiceId);

        if (orderService.isPresent()) {
            OrderServiceModel orderServiceModel = modelMapper.map(orderService.get(), OrderServiceModel.class);
            return ResponseEntity.ok(orderServiceModel);
        }

        return ResponseEntity.notFound().build();
    }
}
