package alura.lista.jpa.jotapeah.modelo;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class Movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TipoMovimentacao tipoMovimentacao;
    private BigDecimal valor;
    private LocalDateTime data;
    private String descricao;
    @ManyToOne
    private Conta conta;
}
