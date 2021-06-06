package com.training.trainingproject.domain.model;

import com.training.trainingproject.api.model.Commentary;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

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

    private OffsetDateTime openDate;
    private OffsetDateTime endDate;

    @OneToMany(mappedBy = "orderWork")
    private List<Commentary> commentaryList = new ArrayList<>();

}
