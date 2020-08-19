package alura.lista.jpa.jotapeah;

import alura.lista.jpa.jotapeah.model.Venda;
import alura.lista.jpa.jotapeah.modelo.TotalizadorComissaoDTO;
import alura.lista.jpa.jotapeah.repository.VendasRepository;
import alura.lista.jpa.jotapeah.service.CalculadorComissaoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CalculadorComissaoServiceTest {

    @InjectMocks
    private CalculadorComissaoService calculadorComissaoService;

    @Mock
    VendasRepository vendasRepository;

    private String cpf = "321321";
    private Integer periodo = 202007;


    @Test
    public void testCenario() {
        List<Venda> vendas = Arrays.asList(
                createVenda(15L, 100L),
                createVenda(10L, 100L));

        Mockito.when(vendasRepository
                .findByCpfAndPeriodo(cpf, periodo))
                .thenReturn(vendas);

        TotalizadorComissaoDTO totalizadorComissaoDTO = calculadorComissaoService.calcularTotal(cpf, periodo);

        Assert.assertNotNull(totalizadorComissaoDTO);
        Assert.assertEquals(BigDecimal.valueOf(25), totalizadorComissaoDTO.getValorTotal());
    }


    private Venda createVenda(Long valorComissao, Long valorTotal) {
        Venda venda = new Venda();
        venda.setValorComissao(BigDecimal.valueOf(valorComissao));
        venda.setValorTotal(BigDecimal.valueOf(valorTotal));
        return venda;
    }

}
