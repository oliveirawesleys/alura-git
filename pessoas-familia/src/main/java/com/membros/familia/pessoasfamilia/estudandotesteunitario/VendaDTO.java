package com.membros.familia.pessoasfamilia.estudandotesteunitario;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class VendaDTO {

    private BigDecimal valorImposto;
    private BigDecimal valorTotal;
}
