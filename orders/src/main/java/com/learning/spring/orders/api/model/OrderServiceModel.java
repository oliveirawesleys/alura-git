package com.learning.spring.orders.api.model;

import com.learning.spring.orders.domain.model.StatusOrderService;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class OrderServiceModel {

    private Long id;
    private ClientResumeModel client;
    private String description;
    private String price;
    private StatusOrderService status;
    private OffsetDateTime dateStart;
    private OffsetDateTime dateFinish;

}
