package com.training.trainingproject.api.controller;

import com.training.trainingproject.api.model.OrderWorkInput;
import com.training.trainingproject.api.model.OrderWorkModel;
import com.training.trainingproject.domain.model.OrderWork;
import com.training.trainingproject.domain.repository.OrderWorkRepository;
import com.training.trainingproject.domain.service.ManagementOrderWorkService;
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
@RequestMapping("/order-work")
public class OrderWorkController {

    @Autowired
    private ManagementOrderWorkService managementOrderWorkService;

    @Autowired
    private OrderWorkRepository orderWorkRepository;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<OrderWorkModel> listAll() {
        return toCollectionModel(orderWorkRepository.findAll());
    }

    @GetMapping("/{orderWorkId}")
    public ResponseEntity<OrderWorkModel> search(@PathVariable Long orderWorkId) {
        Optional<OrderWork> orderWork = orderWorkRepository.findById(orderWorkId);

        if (orderWork.isPresent()) {
            OrderWorkModel orderWorkModel = toModel(orderWork.get());
            return ResponseEntity.ok(orderWorkModel);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderWorkModel create(@Valid @RequestBody OrderWorkInput orderWorkInput) {
        OrderWork orderWork = toEntity(orderWorkInput);
        return toModel(managementOrderWorkService.create(orderWork));
    }

    private OrderWorkModel toModel(OrderWork orderWork) {
        return modelMapper.map(orderWork, OrderWorkModel.class);
    }

    private List<OrderWorkModel> toCollectionModel(List<OrderWork> ordersWork) {
        return ordersWork.stream().map(orderWork -> toModel(orderWork))
                .collect(Collectors.toList());
    }

    private OrderWork toEntity(OrderWorkInput orderWorkInput) {
        return modelMapper.map(orderWorkInput, OrderWork.class);
    }
}
