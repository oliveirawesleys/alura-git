package com.learning.spring.learning.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UserIdInputModel {

    @NotNull
    private Long id;

}
