package com.learning.spring.orders.api.controller;

import com.learning.spring.orders.api.model.OrderServiceModel;
import com.learning.spring.orders.domain.model.OrderService;
import com.learning.spring.orders.domain.repository.OrderServiceRepository;
import com.learning.spring.orders.domain.service.ManagerOrderService;
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
    private ManagerOrderService managerOrderService;

    @Autowired
    private OrderServiceRepository orderServiceRepository;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderService create(@Valid @RequestBody OrderService orderService) {
        return managerOrderService.create(orderService);
    }

    @GetMapping
    public List<OrderService> list() {
        return orderServiceRepository.findAll();
    }

    @GetMapping("/{orderServiceId}")
    public ResponseEntity<OrderServiceModel> find(@PathVariable Long orderServiceId) {
        Optional<OrderService> orderService = orderServiceRepository.findById(orderServiceId);

        if (orderService.isPresent()) {
            OrderServiceModel orderServiceModel = modelMapper.map(orderService.get(), OrderServiceModel.class);
            return ResponseEntity.ok().body(orderServiceModel);
        }
        return ResponseEntity.notFound().build();
    }
}
