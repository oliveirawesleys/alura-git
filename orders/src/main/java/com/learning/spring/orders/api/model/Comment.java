package com.learning.spring.orders.api.model;

import com.learning.spring.orders.domain.model.OrderService;
import lombok.Data;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Data
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private OrderService orderService;

    private String description;
    private OffsetDateTime dateSend;

}
