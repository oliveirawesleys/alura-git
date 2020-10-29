package com.learning.spring.learning.controller;

import com.learning.spring.learning.domain.exception.EntityNotFoundException;
import com.learning.spring.learning.domain.model.Comment;
import com.learning.spring.learning.domain.model.OrderService;
import com.learning.spring.learning.domain.repository.OrderServiceRepository;
import com.learning.spring.learning.domain.service.ManagementOrderService;
import com.learning.spring.learning.model.CommentInput;
import com.learning.spring.learning.model.CommentModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order-service/{orderServiceId}/comments")
public class CommentController {

    @Autowired
    private ManagementOrderService managementOrderService;

    @Autowired
    private OrderServiceRepository orderServiceRepository;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<CommentModel> list(@PathVariable Long orderServiceId) {
        OrderService orderService = orderServiceRepository.findById(orderServiceId)
                .orElseThrow(() -> new EntityNotFoundException("Orderm de serviço não encontrada."));

        return toCollectionModel(orderService.getComments());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommentModel add(@PathVariable Long orderServiceId,
                            @Valid @RequestBody CommentInput commentInput) {
        Comment comment = managementOrderService.addComment(orderServiceId, commentInput.getDescription());

        return toModel(comment);
    }

    private CommentModel toModel(Comment comment) {
        return modelMapper.map(comment, CommentModel.class);
    }

    private List<CommentModel> toCollectionModel(List<Comment> comments) {
        return comments.stream()
                .map(comment -> toModel(comment))
                .collect(Collectors.toList());
    }
}
