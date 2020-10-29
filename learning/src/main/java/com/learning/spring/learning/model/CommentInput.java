package com.learning.spring.learning.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CommentInput {

    @NotBlank
    private String description;

}
