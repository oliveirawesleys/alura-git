package com.training.trainingproject.api.controller;

import com.training.trainingproject.domain.model.OrderWork;
import com.training.trainingproject.domain.repository.OrderWorkRepository;
import com.training.trainingproject.domain.service.ManagementOrderWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
        @RequestMapping("/order-work")
        public class OrderWorkController {

            @Autowired
            private ManagementOrderWorkService managementOrderWorkService;

            @Autowired
            private OrderWorkRepository orderWorkRepository;

            @PostMapping
            @ResponseStatus(HttpStatus.CREATED)
            public OrderWork create(@Valid @RequestBody OrderWork orderWork) {
                return managementOrderWorkService.create(orderWork);
            }

            @GetMapping
            public List<OrderWork> listAll() {
                return orderWorkRepository.findAll();
            }

            @GetMapping("/{orderWorkId}")
            public ResponseEntity<OrderWork> search(@PathVariable Long orderWorkId) {
                Optional<OrderWork> orderWord = orderWorkRepository.findById(orderWorkId);

                if (orderWord.isPresent()) {
                    return ResponseEntity.ok(orderWord.get());
                }
                return ResponseEntity.notFound().build();
            }
}
