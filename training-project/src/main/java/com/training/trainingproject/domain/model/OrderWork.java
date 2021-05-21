package com.training.trainingproject.domain.model;

import lombok.Data;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class OrderWork {

    private Long id;
    private User user;
    private String description;
    private BigDecimal price;
    private StatusOrderWork status;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

}
