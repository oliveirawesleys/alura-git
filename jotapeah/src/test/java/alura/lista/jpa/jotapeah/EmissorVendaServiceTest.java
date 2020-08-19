package alura.lista.jpa.jotapeah;

import alura.lista.jpa.jotapeah.exception.EmissorVendaExcpetion;
import alura.lista.jpa.jotapeah.exception.SistemaERPExcpetion;
import alura.lista.jpa.jotapeah.model.Venda;
import alura.lista.jpa.jotapeah.modelo.VendaDTO;
import alura.lista.jpa.jotapeah.service.EmissorVendaService;
import alura.lista.jpa.jotapeah.service.SistemaERPProxyService;
import org.assertj.core.internal.bytebuddy.matcher.ElementMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

@RunWith(MockitoJUnitRunner.class)
public class EmissorVendaServiceTest {

    @InjectMocks
    private EmissorVendaService emissorVendaService;

    @Mock
    private SistemaERPProxyService sistemaERPProxyService;

    @Captor
    private ArgumentCaptor<VendaDTO> captor;

    @Test
    public void testEmitir() throws EmissorVendaExcpetion, SistemaERPExcpetion {
        Venda venda = createVenda(10L, 100L);
        emissorVendaService.emitir(venda);

        Mockito.verify(sistemaERPProxyService).emitir(captor.capture());

        VendaDTO value = captor.getValue();

        Assert.assertEquals(venda.getValorComissao(), value.getValorImposto());
        Assert.assertEquals(venda.getValorTotal(), value.getValorTotal());
    }

    @Test(expected = EmissorVendaExcpetion.class)
    public void testErroEmitirVenda() throws EmissorVendaExcpetion, SistemaERPExcpetion {
        Venda venda = createVenda(0L, 120L);

        Mockito.doThrow(new SistemaERPExcpetion())
                .when(sistemaERPProxyService).emitir(Mockito.any());

        emissorVendaService.emitir(venda);
    }


    private Venda createVenda(Long valorComissao, Long valorTotal) {
        Venda nota = new Venda();
        nota.setValorComissao(BigDecimal.valueOf(valorComissao));
        nota.setValorTotal(BigDecimal.valueOf(valorTotal));
        return nota;

    }
}
