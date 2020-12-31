package com.learning.spring.orders.domain.model;

import com.learning.spring.orders.api.model.Comment;
import com.learning.spring.orders.domain.exception.BusinessException;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class OrderService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Client client;

    private String description;
    private String price;

    @Enumerated(EnumType.STRING)
    private StatusOrderService status;

    private OffsetDateTime dateStart;
    private OffsetDateTime dateFinish;

    @OneToMany(mappedBy = "orderService")
    private List<Comment> commentsList = new ArrayList<>();

    boolean canBeFinalize() {
        return StatusOrderService.OPEN.equals(getStatus());
    }

    boolean canNotBeFinalize() {
        return !canBeFinalize();
    }

    public void finish() {
        if (canNotBeFinalize()) {
            throw new BusinessException("Ordem de serviço não pode ser finalizada.");
        }

        setStatus(StatusOrderService.FINISH);
        setDateFinish(OffsetDateTime.now());
    }
}
