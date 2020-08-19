package alura.lista.jpa.jotapeah.service;

import alura.lista.jpa.jotapeah.model.Venda;
import alura.lista.jpa.jotapeah.modelo.TotalizadorComissaoDTO;
import alura.lista.jpa.jotapeah.repository.VendasRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class CalculadorComissaoService {

    private VendasRepository vendasRepository;

    public CalculadorComissaoService(VendasRepository vendasRepository) {
        this.vendasRepository = vendasRepository;
    }

    public TotalizadorComissaoDTO calcularTotal(String cpf, Integer periodo) {
        List<Venda> vendas = vendasRepository.findByCpfAndPeriodo(cpf, periodo);

        TotalizadorComissaoDTO totalizadorComissaoDTO = new TotalizadorComissaoDTO();
        totalizadorComissaoDTO.setValorTotal(getValorComissao(vendas));
        return totalizadorComissaoDTO;
    }

    private BigDecimal getValorComissao(List<Venda> vendas) {
        AtomicReference<BigDecimal> totalComissao = new AtomicReference<>(BigDecimal.ZERO);
        vendas.forEach(nota -> totalComissao.set(totalComissao.get().add(nota.getValorComissao())));
        return totalComissao.get();
    }
}
