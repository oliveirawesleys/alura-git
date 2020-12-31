package com.learning.spring.orders.api.model;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class CommentModel {

    private Long id;
    private String description;
    private OffsetDateTime dateSend;

}
