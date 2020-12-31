package com.learning.spring.orders.api.controller;

import com.learning.spring.orders.api.model.OrderServiceInput;
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
import java.util.stream.Collectors;

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
    public OrderServiceModel create(@Valid @RequestBody OrderServiceInput orderServiceInput) {
        OrderService orderService = toEntity(orderServiceInput);

        return toModel(managerOrderService.create(orderService));
    }

    @GetMapping
    public List<OrderServiceModel> list() {
        return toCollectionModel(orderServiceRepository.findAll());
    }

    @GetMapping("/{orderServiceId}")
    public ResponseEntity<OrderServiceModel> find(@PathVariable Long orderServiceId) {
        Optional<OrderService> orderService = orderServiceRepository.findById(orderServiceId);

        if (orderService.isPresent()) {
            OrderServiceModel orderServiceModel = toModel(orderService.get());
            return ResponseEntity.ok().body(orderServiceModel);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{orderServiceId}/finish")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void finish(@PathVariable Long orderServiceId) {
        managerOrderService.finishOrder(orderServiceId);
    }

    private OrderServiceModel toModel(OrderService orderService) {
        return modelMapper.map(orderService, OrderServiceModel.class);
    }

    private List<OrderServiceModel> toCollectionModel(List<OrderService> ordersService) {
        return ordersService.stream()
                .map(orderService -> toModel(orderService))
                .collect(Collectors.toList());
    }

    private OrderService toEntity(OrderServiceInput orderServiceInput) {
        return modelMapper.map(orderServiceInput, OrderService.class);
    }
}
