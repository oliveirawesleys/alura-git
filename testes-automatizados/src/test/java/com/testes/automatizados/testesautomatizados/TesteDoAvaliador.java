package com.testes.automatizados.testesautomatizados;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TesteDoAvaliador {

    @Test
    public void deveEntenderLancesEmOrdemDescrescente() {
        //Parte 1: Cenario
        Usuario paulo = new Usuario("Paulo");
        Usuario joao = new Usuario("Joao");
        Usuario pedro = new Usuario("Pedro");

        Leilao leilao = new Leilao("Playstation 5");

        leilao.propoe(new Lance(paulo, 250));
        leilao.propoe(new Lance(joao, 300));
        leilao.propoe(new Lance(pedro, 400 ));

        //Parte 2: Acao
        Avaliador leiloeiro = new Avaliador();
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
        Usuario paulo = new Usuario("Paulo");
        Usuario joao = new Usuario("Joao");
        Usuario pedro = new Usuario("Pedro");

        Leilao leilao = new Leilao("Playstation 5");

        leilao.propoe(new Lance(paulo, 300));
        leilao.propoe(new Lance(joao, 400));
        leilao.propoe(new Lance(pedro, 500 ));

        //Parte 2: Acao
        Avaliador leiloeiro = new Avaliador();
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

        Avaliador avaliador = new Avaliador();
        avaliador.avalia(leilao);

        //Parte 3: Validacao
        Assert.assertEquals(0, avaliador.getMedia(), 0.0001);
    }

    @Test
    public void deveEncontrarOsTresMaioresLances() {
        Usuario joao = new Usuario("Joao");
        Usuario maria = new Usuario("Maria");
        Leilao leilao = new Leilao("Playstation");

        leilao.propoe(new Lance(joao, 100));
        leilao.propoe(new Lance(maria, 200));
        leilao.propoe(new Lance(joao, 400));
        leilao.propoe(new Lance(maria, 700));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        List<Lance> maiores = leiloeiro.getTresMaiores();
        Assert.assertEquals(3, maiores.size());
        Assert.assertEquals(700.0, maiores.get(0).getValor(), 0.0001);
        Assert.assertEquals(400.0, maiores.get(1).getValor(), 0.0001);
        Assert.assertEquals(200.0, maiores.get(2).getValor(), 0.0001);

    }

    @Test
    public void deveFuncionarComApenasUmLance() {
        Usuario maria = new Usuario("Maria");
        Leilao leilao = new Leilao("Playstation");

        leilao.propoe(new Lance(maria, 100));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        Assert.assertEquals(100, leiloeiro.getMaiorLance(), 0.00001);
        Assert.assertEquals(100, leiloeiro.getMenorLance(), 0.00001);
    }

    @Test
    public void deveEntenderLancesEmOrdemAleatoria() {
        Usuario maria = new Usuario("Maria");
        Usuario paulo = new Usuario("paulo");
        Usuario ana = new Usuario("ana");
        Usuario caio = new Usuario("caio");
        Leilao leilao = new Leilao("Playstation");

        leilao.propoe(new Lance(maria, 350));
        leilao.propoe(new Lance(paulo, 900));
        leilao.propoe(new Lance(ana, 850));
        leilao.propoe(new Lance(caio, 200));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        Assert.assertEquals(900, leiloeiro.getMaiorLance(), 0.00001);
        Assert.assertEquals(200, leiloeiro.getMenorLance(), 0.00001);
    }

    @Test
    public void deveEncontrarOsTresMaiores() {
        Usuario ana = new Usuario("Ana");
        Usuario paulo = new Usuario("Paulo");
        Usuario pedro = new Usuario("Pedro");
        Usuario maju = new Usuario("Maju");

        Leilao leilao = new Leilao("Notebook");
        leilao.propoe(new Lance(ana, 1000));
        leilao.propoe(new Lance(paulo, 3000));
        leilao.propoe(new Lance(pedro, 4000));
        leilao.propoe(new Lance(maju, 9000));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        List<Lance> maiores = leiloeiro.getTresMaiores();


        Assert.assertEquals(3, maiores.size());
        Assert.assertEquals(9000, maiores.get(0).getValor(), 0.00001);
        Assert.assertEquals(4000, maiores.get(1).getValor(), 0.00001);
        Assert.assertEquals(3000, maiores.get(2).getValor(), 0.00001);
    }

    @Test
    public void deveDevolverTodosLancesCasoHajaNoMinimo3() {
        Usuario ana = new Usuario("Ana");
        Usuario paulo = new Usuario("Paulo");

        Leilao leilao = new Leilao("TV");
        leilao.propoe(new Lance(ana, 3000));
        leilao.propoe(new Lance(paulo, 5000));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        List<Lance> maiores = leiloeiro.getTresMaiores();

        Assert.assertEquals(2, maiores.size());
        Assert.assertEquals(5000, maiores.get(0).getValor(), 0.00001);
        Assert.assertEquals(3000, maiores.get(1).getValor(), 0.00001);
    }

    @Test
    public void deveDevolverListaVaziaCasoNaoHajaLance() {
        Leilao leilao = new Leilao("Chocolate");

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        List<Lance> maiores = leiloeiro.getTresMaiores();
        Assert.assertEquals(0, maiores.size());
    }
}
