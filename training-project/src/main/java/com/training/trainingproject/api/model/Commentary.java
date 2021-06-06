package com.training.trainingproject.api.model;

import com.training.trainingproject.domain.model.OrderWork;
import lombok.Data;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Data
public class Commentary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private OrderWork orderWork;

    private String description;
    private OffsetDateTime dateSend;
}
