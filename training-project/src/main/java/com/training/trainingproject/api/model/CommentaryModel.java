package com.training.trainingproject.api.model;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class CommentaryModel {

    private Long id;
    private String description;
    private OffsetDateTime dateSend;

}
