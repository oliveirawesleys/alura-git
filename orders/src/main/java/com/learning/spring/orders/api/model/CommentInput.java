package com.learning.spring.orders.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CommentInput {

    @NotBlank
    private String description;

}
