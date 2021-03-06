package com.testes.automatizados.testesautomatizados;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

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

        Assert.assertEquals(400, leiloeiro.getMedia(), 0.00001);
    }

    @Test
    public void testaMediaDeZeroLance() {
        //Parte 1: 
    }
}
