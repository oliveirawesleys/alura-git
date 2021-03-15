package com.testes.automatizados.testesautomatizados;

import org.junit.*;
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
    public void setUp() {
        this.leiloeiro = new Avaliador();
        this.paulo = new Usuario("Paulo");
        this.joao = new Usuario("Joao");
        this.pedro = new Usuario("Pedro");
    }

    @After
    public void finaliza() {
        System.out.println("Fim!");
    }

    @BeforeClass // são executados apenas uma vez, antes de todos os métodos de teste
    public static void testandoBeforeClass() {
        System.out.println("before class");
    }

    @AfterClass //é executado uma vez, após a execução do último método de teste da classe.
    public static void testandoAfterClass() {
        System.out.println("after class");
    }

    @Test
    public void deveEntenderLancesEmOrdemDescrescente() {
        //Parte 1: Cenario

        Leilao leilao = new CriadorDeLeilao().para("Televisao")
                .lance(paulo, 250)
                .lance(joao, 300)
                .lance(pedro, 400)
                .constroi();


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

        Leilao leilao = new CriadorDeLeilao().para("Lanhca")
                .lance(paulo, 300)
                .lance(joao, 400)
                .lance(pedro, 500)
                .constroi();


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

        Leilao leilao = new CriadorDeLeilao().para("Notebook")
                .lance(joao, 100)
                .lance(pedro, 200)
                .lance(joao, 400)
                .lance(pedro, 700)
                .constroi();

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
        Leilao leilao = new CriadorDeLeilao().para("Playstation")
                .lance(paulo, 900)
                .lance(joao, 850)
                .lance(pedro, 200)
                .constroi();


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

        Leilao leilao = new CriadorDeLeilao().para("Mesa")
                .lance(joao, 3000)
                .lance(paulo, 5000)
                .constroi();

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
