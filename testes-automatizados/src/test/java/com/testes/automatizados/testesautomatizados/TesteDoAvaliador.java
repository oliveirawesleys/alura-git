package com.testes.automatizados.testesautomatizados;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

import java.util.List;

@RunWith(JUnit4ClassRunner.class)
public class TesteDoAvaliador {

    private Avaliador leiloeiro;
    private Usuario paulo;
    private Usuario joao;
    private Usuario pedro;

    @Before
    public void criaAvaliador() {
        this.leiloeiro = new Avaliador();
        this.paulo = new Usuario("Paulo");
        this.joao = new Usuario("Joao");
        this.pedro = new Usuario("Pedro");
    }

    @Test
    public void deveEntenderLancesEmOrdemDescrescente() {
        //Parte 1: Cenario

        Leilao leilao = new Leilao("Playstation 5");

        leilao.propoe(new Lance(paulo, 250));
        leilao.propoe(new Lance(joao, 300));
        leilao.propoe(new Lance(pedro, 400 ));

        //Parte 2: Acao
        leiloeiro.avalia(leilao);

        //Parte 3: Validacao
        double maiorEsperado = 400;
        double menorEsperado = 250;

        Assert.assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);

        Assert.assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);
    }

    @Test
    public void deveCalcularMedia() {
        //Parte 1: Cenario

        Leilao leilao = new Leilao("Playstation 5");

        leilao.propoe(new Lance(paulo, 300));
        leilao.propoe(new Lance(joao, 400));
        leilao.propoe(new Lance(pedro, 500 ));

        //Parte 2: Acao
        leiloeiro.avalia(leilao);

        //Assert.assertEquals(400, leiloeiro.getMedia(), 0.0001);
        Assert.assertEquals(0, leiloeiro.getMedia(), 0.0001);
    }

    @Test
    public void testaMediaDeZeroLance() {
        //Parte 1: Cenario
        Usuario u1 = new Usuario("Paulo");

        //Parte 2: Acao
        Leilao leilao = new Leilao("Iphone");

        leiloeiro.avalia(leilao);

        //Parte 3: Validacao
        Assert.assertEquals(0, leiloeiro.getMedia(), 0.0001);
    }

    @Test
    public void deveEncontrarOsTresMaioresLances() {

        Leilao leilao = new Leilao("Playstation");

        leilao.propoe(new Lance(joao, 100));
        leilao.propoe(new Lance(pedro, 200));
        leilao.propoe(new Lance(joao, 400));
        leilao.propoe(new Lance(pedro, 700));

        leiloeiro.avalia(leilao);

        List<Lance> maiores = leiloeiro.getTresMaiores();
        Assert.assertEquals(3, maiores.size());
        Assert.assertEquals(700.0, maiores.get(0).getValor(), 0.0001);
        Assert.assertEquals(400.0, maiores.get(1).getValor(), 0.0001);
        Assert.assertEquals(200.0, maiores.get(2).getValor(), 0.0001);

    }

    @Test
    public void deveFuncionarComApenasUmLance() {
        Leilao leilao = new Leilao("Playstation");

        leilao.propoe(new Lance(pedro, 100));

        leiloeiro.avalia(leilao);

        Assert.assertEquals(100, leiloeiro.getMaiorLance(), 0.00001);
        Assert.assertEquals(100, leiloeiro.getMenorLance(), 0.00001);
    }

    @Test
    public void deveEntenderLancesEmOrdemAleatoria() {
        Leilao leilao = new Leilao("Playstation");

        leilao.propoe(new Lance(paulo, 900));
        leilao.propoe(new Lance(joao, 850));
        leilao.propoe(new Lance(pedro, 200));

        leiloeiro.avalia(leilao);

        Assert.assertEquals(900, leiloeiro.getMaiorLance(), 0.00001);
        Assert.assertEquals(200, leiloeiro.getMenorLance(), 0.00001);
    }

    @Test
    public void deveEncontrarOsTresMaiores() {
        Leilao leilao = new CriadorDeLeilao().para("Playstation 3 novo")
                .lance(joao, 4000)
                .lance(paulo, 9000)
                .lance(pedro, 3000)
                .constroi();

        leiloeiro.avalia(leilao);

        List<Lance> maiores = leiloeiro.getTresMaiores();


        Assert.assertEquals(3, maiores.size());
        Assert.assertEquals(9000, maiores.get(0).getValor(), 0.00001);
        Assert.assertEquals(4000, maiores.get(1).getValor(), 0.00001);
        Assert.assertEquals(3000, maiores.get(2).getValor(), 0.00001);
    }

    @Test
    public void deveDevolverTodosLancesCasoHajaNoMinimo3() {

        Leilao leilao = new Leilao("TV");
        leilao.propoe(new Lance(joao, 3000));
        leilao.propoe(new Lance(paulo, 5000));

        leiloeiro.avalia(leilao);

        List<Lance> maiores = leiloeiro.getTresMaiores();

        Assert.assertEquals(2, maiores.size());
        Assert.assertEquals(5000, maiores.get(0).getValor(), 0.00001);
        Assert.assertEquals(3000, maiores.get(1).getValor(), 0.00001);
    }

    @Test
    public void deveDevolverListaVaziaCasoNaoHajaLance() {
        Leilao leilao = new Leilao("Chocolate");

        leiloeiro.avalia(leilao);

        List<Lance> maiores = leiloeiro.getTresMaiores();
        Assert.assertEquals(0, maiores.size());
    }
}
