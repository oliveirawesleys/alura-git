package com.algaworks.osworks.osworksapi.model;

import lombok.Data;

import java.time.OffsetDateTime;
@Data
public class ComentarioModel {

    private Long id;
    private String descricao;
    private OffsetDateTime dataEnvio;

}
