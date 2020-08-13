package com.membros.familia.pessoasfamilia.estudandotesteunitario;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
public class Venda {

    @Id
    private BigDecimal valorComissao;
    private BigDecimal valorTotal;
    private String cpf;
    private Integer periodo;
}
