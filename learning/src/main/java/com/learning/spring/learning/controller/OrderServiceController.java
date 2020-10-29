package com.learning.spring.learning.controller;

import com.learning.spring.learning.domain.model.OrderService;
import com.learning.spring.learning.domain.repository.OrderServiceRepository;
import com.learning.spring.learning.domain.service.ManagementOrderService;
import com.learning.spring.learning.model.OrderServiceInputModel;
import com.learning.spring.learning.model.OrderServiceModel;
import org.hibernate.criterion.Order;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public OrderServiceModel create(@Valid @RequestBody OrderServiceInputModel orderInput) {
        OrderService order = toEntity(orderInput);
        return toModel(managementOrderService.create(order));
    }

    @GetMapping
    public List<OrderServiceModel> list() {
        return toCollectionModel(orderServiceRepository.findAll());
    }

    @GetMapping("/{orderServiceId}")
    public ResponseEntity<OrderServiceModel> search(@PathVariable Long orderServiceId) {
        Optional<OrderService> orderService = orderServiceRepository.findById(orderServiceId);

        if (orderService.isPresent()) {
            OrderServiceModel orderServiceModel = toModel(orderService.get());
            return ResponseEntity.ok(orderServiceModel);
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{orderServiceId}/finish")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void finish(@PathVariable Long orderServiceId) {
        managementOrderService.finishOrderService(orderServiceId);
    }

    private OrderServiceModel toModel(OrderService orderService) {
        return modelMapper.map(orderService, OrderServiceModel.class);
    }

    private List<OrderServiceModel> toCollectionModel(List<OrderService> orderServices) {
        return orderServices.stream()
                .map(orderService -> toModel(orderService))
                .collect(Collectors.toList());
    }

    private OrderService toEntity(OrderServiceInputModel orderInput) {
        return modelMapper.map(orderInput, OrderService.class);
    }
}
