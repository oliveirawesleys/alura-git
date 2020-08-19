package alura.lista.jpa.jotapeah.modelo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class VendaDTO {

    private BigDecimal valorImposto;
    private BigDecimal valorTotal;

}
