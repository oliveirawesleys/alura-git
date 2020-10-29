package com.learning.spring.learning.model;

import com.learning.spring.learning.domain.model.StatusOrderService;
import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
public class OrderServiceModel {

    private Long id;
    private UserAbstractModel user;
    private String description;
    private BigDecimal price;
    private StatusOrderService status;
    private OffsetDateTime dateStart;
    private OffsetDateTime dateFinish;

}
