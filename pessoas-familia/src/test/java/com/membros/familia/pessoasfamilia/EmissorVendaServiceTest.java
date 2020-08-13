package com.membros.familia.pessoasfamilia;

import com.membros.familia.pessoasfamilia.estudandotesteunitario.EmissorVendaService;
import com.membros.familia.pessoasfamilia.estudandotesteunitario.SistemaERPProxyService;
import com.membros.familia.pessoasfamilia.estudandotesteunitario.Venda;
import com.membros.familia.pessoasfamilia.estudandotesteunitario.VendaDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class EmissorVendaServiceTest {

    @InjectMocks
    private EmissorVendaService emissorVendaService;

    @Mock
    private SistemaERPProxyService sistemaERPProxyService;

    @Captor
    private ArgumentCaptor<VendaDTO> captor;

    @Test
    public void testEmitir() throws Exception {
        Venda venda = createVenda(10L, 100L);
        emissorVendaService.emitir(venda);

        verify(sistemaERPProxyService).emitir(captor.capture());

        VendaDTO value = captor.getValue();
        Assert.assertEquals(venda.getValorComissao(), value.getValorImposto());
        Assert.assertEquals(venda.getValorTotal(), value.getValorTotal());
    }

    @Test(expected = Exception.class)
    public void erroEmitirVenda() throws Exception {
        Venda venda = createVenda(0L, 120L);

        doThrow(new Exception())
                .when(sistemaERPProxyService).emitir(any());

        emissorVendaService.emitir(venda);
    }


    private Venda createVenda(Long valorComissao, Long valorTotal) {
        Venda nota = new Venda();
        nota.setValorComissao(BigDecimal.valueOf(valorComissao));
        nota.setValorTotal(BigDecimal.valueOf(valorTotal));
        return nota;
    }
}
