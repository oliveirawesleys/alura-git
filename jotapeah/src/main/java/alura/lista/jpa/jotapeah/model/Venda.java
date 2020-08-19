package alura.lista.jpa.jotapeah.model;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class Venda {

    private BigDecimal valorComissao;
    private BigDecimal valorTotal;
}
