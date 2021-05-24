package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ReajusteServiceTest {

    private ReajusteService reajusteService;
    private Funcionario funcionario;

    @Before
    public void inicializar() {
        System.out.println("Inicio!");
        this.reajusteService = new ReajusteService();
        this.funcionario = new Funcionario("Chaves", LocalDate.now(), new BigDecimal("1000.00"));
    }

    @After
    public void finalizar() {
        System.out.println("Final!");
    }

    @Test
    public void reajusteDeveriaSerDeDezPorcentoQuandoDesempenhoForADesejar() {
        reajusteService.concederReajuste(funcionario, Desempenho.A_DESEJAR);
        Assert.assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDeQuinzePorcentoQuandoDesempenhoForBom() {
        reajusteService.concederReajuste(funcionario, Desempenho.BOM);
        Assert.assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDeVintePorCentoQuandoDesempenhoForOtimo() {
         reajusteService.concederReajuste(funcionario, Desempenho.OTIMO);
        Assert.assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }
}
