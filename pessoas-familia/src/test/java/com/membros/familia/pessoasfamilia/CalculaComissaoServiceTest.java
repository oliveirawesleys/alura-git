package com.membros.familia.pessoasfamilia;

import com.membros.familia.pessoasfamilia.estudandotesteunitario.CalculaComissaoService;
import com.membros.familia.pessoasfamilia.estudandotesteunitario.TotalizadorComissaoDTO;
import com.membros.familia.pessoasfamilia.estudandotesteunitario.Venda;
import com.membros.familia.pessoasfamilia.estudandotesteunitario.VendaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CalculaComissaoServiceTest {

    @InjectMocks
    private CalculaComissaoService calculaComissaoService;

    @Mock
    private VendaRepository vendaRepository;

    private String cpf = "123123123";
    private Integer periodo = 202005;


    @Test
    public void testCenario1() {
        List<Venda> vendas = Arrays.asList(
                createVenda(15L, 150L),
                createVenda(10L, 100L));

        when(vendaRepository
                .findByCpfAndPeriodo(cpf, periodo))
                .thenReturn(vendas);

        TotalizadorComissaoDTO totalizadorComissaoDTO = calculaComissaoService.calcularTotal(cpf, periodo);

        assertNotNull(totalizadorComissaoDTO);
        assertEquals(BigDecimal.valueOf(25L), totalizadorComissaoDTO.getValorTotal());
    }

    private Venda createVenda(Long valorComissao, Long valorTotal) {
        Venda venda = new Venda();
        venda.setValorComissao(BigDecimal.valueOf(valorComissao));
        venda.setValorTotal(BigDecimal.valueOf(valorTotal));
        return venda;
    }

}
