package com.learning.spring.learning.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.learning.spring.learning.domain.ValidationGroups;
import lombok.Data;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Entity
@Data
public class OrderService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Valid
    @ConvertGroup(from = Default.class, to = ValidationGroups.UserId.class)
    @NotNull
    @ManyToOne
    private User user;

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
