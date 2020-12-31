package com.learning.spring.orders.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ClientIdInput {

    @NotNull
    private Long id;

}
