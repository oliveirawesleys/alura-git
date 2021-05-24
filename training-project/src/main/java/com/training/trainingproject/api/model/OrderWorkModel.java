package com.training.trainingproject.api.model;

import com.training.trainingproject.domain.model.StatusOrderWork;
import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
public class OrderWorkModel {

    private Long id;
    private String nameUser;
    private String description;
    private BigDecimal price;
    private StatusOrderWork status;
    private OffsetDateTime openDate;
    private OffsetDateTime endDate;

}
