package com.training.trainingproject.api.controller;

import com.training.trainingproject.api.model.Commentary;
import com.training.trainingproject.api.model.CommentaryInput;
import com.training.trainingproject.api.model.CommentaryModel;
import com.training.trainingproject.domain.exception.EntityNotFoundException;
import com.training.trainingproject.domain.model.OrderWork;
import com.training.trainingproject.domain.repository.OrderWorkRepository;
import com.training.trainingproject.domain.service.ManagementOrderWorkService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order-work/{orderWorkId}/comments")
public class CommentaryController {

    @Autowired
    ManagementOrderWorkService managementOrderWorkService;

    @Autowired
    OrderWorkRepository orderWorkRepository;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping
    public List<CommentaryModel> list(@PathVariable Long orderWorkId) {
        OrderWork orderWork = orderWorkRepository.findById(orderWorkId)
                .orElseThrow(() -> new EntityNotFoundException("Ordem de serviço não encontrada."));

        return toCollectionModel(orderWork.getCommentaryList());
    }



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommentaryModel add(@PathVariable Long orderWorkId, @Valid @RequestBody CommentaryInput commentaryInput) {
        Commentary commentary = managementOrderWorkService.addCommentary(orderWorkId, commentaryInput.getDescription());
        return toModel(commentary);
    }

    private CommentaryModel toModel(Commentary commentary) {
        return modelMapper.map(commentary, CommentaryModel.class);
    }

    private List<CommentaryModel> toCollectionModel(List<Commentary> commentaryList) {
        return commentaryList.stream().map(comment -> toModel(comment))
                .collect(Collectors.toList());
    }
}
