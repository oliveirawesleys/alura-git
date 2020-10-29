package com.learning.spring.learning.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.learning.spring.learning.domain.ValidationGroups;
import com.learning.spring.learning.domain.exception.BusinessException;
import lombok.Data;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class OrderService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;
    private String description;
    private String price;

    @Enumerated(EnumType.STRING)
    private StatusOrderService status;

    private OffsetDateTime dateStart;
    private OffsetDateTime dateFinish;

    @OneToMany(mappedBy = "orderService")
    private List<Comment> comments = new ArrayList<>();

    public boolean canBeFinish() {
        return StatusOrderService.ABERTA.equals(getStatus());
    }

    public boolean notCanBeFinish() {
        return !canBeFinish();
    }

    public void finish() {
        if (notCanBeFinish()) {
            throw new BusinessException("Ordem de serviço não pode ser finalizada.");
        }
        setStatus(StatusOrderService.FINALIZADA);
        setDateFinish(OffsetDateTime.now());
    }
}
