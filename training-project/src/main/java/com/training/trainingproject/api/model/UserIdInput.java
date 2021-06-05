package com.training.trainingproject.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UserIdInput {

    @NotNull
    private Long id;

}
