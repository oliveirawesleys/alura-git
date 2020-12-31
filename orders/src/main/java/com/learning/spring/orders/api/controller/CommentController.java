package com.learning.spring.orders.api.controller;

import com.learning.spring.orders.api.model.Comment;
import com.learning.spring.orders.api.model.CommentInput;
import com.learning.spring.orders.api.model.CommentModel;
import com.learning.spring.orders.domain.exception.EntityNotFoundException;
import com.learning.spring.orders.domain.model.OrderService;
import com.learning.spring.orders.domain.repository.OrderServiceRepository;
import com.learning.spring.orders.domain.service.ManagerOrderService;
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
    private ManagerOrderService managerOrderService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private OrderServiceRepository orderServiceRepository ;

    @GetMapping
    public List<CommentModel> list(@PathVariable Long orderServiceId) {
        OrderService orderService = orderServiceRepository.findById(orderServiceId)
                .orElseThrow(() -> new EntityNotFoundException("Ordem de serviço não encontrada"));

        return toCollectionModel(orderService.getCommentsList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommentModel add(@PathVariable Long orderServiceId, @Valid @RequestBody CommentInput commentInput) {
        Comment comment = managerOrderService.addComment(orderServiceId, commentInput.getDescription());

        return toModel(comment);
    }

    private CommentModel toModel(Comment comment) {
        return modelMapper.map(comment, CommentModel.class);
    }

    private List<CommentModel> toCollectionModel(List<Comment> comments) {
        return comments.stream().map(comment -> toModel(comment))
                .collect(Collectors.toList());
    }
}
