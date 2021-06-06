package com.training.trainingproject.domain.model;

import com.training.trainingproject.api.model.Commentary;
import com.training.trainingproject.domain.exception.BusinessException;
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

    public boolean canBeFinalize() {
        return StatusOrderWork.OPEN.equals(getStatus());
    }

    public boolean canNotBeFinalize() {
        return !canBeFinalize();
    }

    public void finalizeOrder() {
        if (canNotBeFinalize()) {
            throw new BusinessException("Ordem de serviço não pode ser finalizada.");
        }

        setStatus(StatusOrderWork.FINALIZE);
        setEndDate(OffsetDateTime.now());

    }
}
