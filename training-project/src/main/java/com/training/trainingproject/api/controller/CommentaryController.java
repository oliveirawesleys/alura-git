package com.training.trainingproject.api.controller;

import com.training.trainingproject.api.model.Commentary;
import com.training.trainingproject.api.model.CommentaryInput;
import com.training.trainingproject.api.model.CommentaryModel;
import com.training.trainingproject.domain.service.ManagementOrderWorkService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/order-work/{orderWorkId}/comments")
public class CommentaryController {

    @Autowired
    ManagementOrderWorkService managementOrderWorkService;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommentaryModel add(@PathVariable Long orderWorkId, @Valid @RequestBody CommentaryInput commentaryInput) {
        Commentary commentary = managementOrderWorkService.addCommentary(orderWorkId, commentaryInput.getDescription());
        return toModel(commentary);
    }

    private CommentaryModel toModel(Commentary commentary) {
        return modelMapper.map(commentary, CommentaryModel.class);
    }
}
