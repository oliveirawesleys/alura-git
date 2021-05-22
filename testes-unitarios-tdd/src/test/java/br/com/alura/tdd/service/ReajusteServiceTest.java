package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ReajusteServiceTest {

    @Test
    public void reajusteDeveriaSerDeDezPorcentoQuandoDesempenhoForADesejar() {
        ReajusteService reajusteService = new ReajusteService();
        Funcionario funcionario = new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000.00"));

        reajusteService.concederReajuste(funcionario, Desempenho.A_DESEJAR);

        Assert.assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDeQuinzePorcentoQuandoDesempenhoForBom() {
        ReajusteService reajusteService = new ReajusteService();
        Funcionario funcionario = new Funcionario("Bruna", LocalDate.now(), new BigDecimal("1000.00"));

        reajusteService.concederReajuste(funcionario, Desempenho.BOM);

        Assert.assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDeVintePorCentoQuandoDesempenhoForOtimo() {
        ReajusteService reajusteService = new ReajusteService();
        Funcionario funcionario = new Funcionario("Carol", LocalDate.now(), new BigDecimal("1000.00"));

        reajusteService.concederReajuste(funcionario, Desempenho.OTIMO);

        Assert.assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }
}
