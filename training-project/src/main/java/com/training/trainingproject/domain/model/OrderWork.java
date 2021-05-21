package com.training.trainingproject.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class OrderWork {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private String description;
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private StatusOrderWork status;
    
    private LocalDateTime openDate;
    private LocalDateTime endDate;

}
