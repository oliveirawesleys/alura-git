package com.algaworks.osworks.osworksapi.model;

import com.algaworks.osworks.osworksapi.domain.model.StatusOrdemServico;
import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
public class OrdemServicoModel {

    private Long id;
    private ClienteResumoModel cliente;
    private String descricao;
    private BigDecimal preco;
    private StatusOrdemServico status;
    private OffsetDateTime dataAbertura;
    private OffsetDateTime dataFinalizacao;
}
