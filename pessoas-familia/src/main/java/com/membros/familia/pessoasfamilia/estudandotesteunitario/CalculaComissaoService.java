package com.membros.familia.pessoasfamilia.estudandotesteunitario;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class CalculaComissaoService {

    private VendaRepository vendaRepository;

    public CalculaComissaoService(VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    public TotalizadorComissaoDTO calcularTotal(String cpf, Integer periodo) {
        List<Venda> vendas = vendaRepository.findByCpfAndPeriodo(cpf, periodo);

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
