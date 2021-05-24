package com.training.trainingproject.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.training.trainingproject.domain.ValidationGroups;
import lombok.Data;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Entity
@Data
public class OrderWork {

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
    private BigDecimal price;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Enumerated(EnumType.STRING)
    private StatusOrderWork status;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private OffsetDateTime openDate;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private OffsetDateTime endDate;

}
