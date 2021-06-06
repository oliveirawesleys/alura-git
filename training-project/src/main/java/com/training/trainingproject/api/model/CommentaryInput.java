package com.training.trainingproject.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CommentaryInput {

    @NotBlank
    private String description;

}
