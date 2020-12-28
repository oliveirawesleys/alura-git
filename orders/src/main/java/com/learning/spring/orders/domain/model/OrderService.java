package com.learning.spring.orders.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.learning.spring.orders.domain.ValidationGroups;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Entity
@Getter
@Setter
public class OrderService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Valid
    @ConvertGroup(from = Default.class, to = ValidationGroups.ClientId.class)
    @NotNull
    @ManyToOne
    private Client client;

    @NotBlank
    private String description;

    @NotNull
    private String price;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Enumerated(EnumType.STRING)
    private StatusOrderService status;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private OffsetDateTime dateStart;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private OffsetDateTime dateFinish;

}
