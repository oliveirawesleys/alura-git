package com.testes.automatizados.testesautomatizados;

import org.junit.Assert;
import org.junit.Test;

public class TesteContaMaluca {

    @Test
    public void deveRetornarComMaiorQue30() {
        int numero = 40;
        ContaMaluca conta = new ContaMaluca();

        int resultado = conta.conta(numero);
        Assert.assertEquals(160, resultado);
    }

    @Test
    public void deveRetornarComMaiorQue10EMenorQue30() {
        int numero = 20;
        ContaMaluca conta = new ContaMaluca();

        int resultado = conta.conta(numero);

        Assert.assertEquals(60, resultado);

    }

    @Test
    public void deveRetornarComNumeroMenorQue10() {
        int numero = 5;
        ContaMaluca conta = new ContaMaluca();

        int resultado = conta.conta(numero);

        Assert.assertEquals(10, resultado);
    }

    @Test
    public void deveMultiplicarNumerosMenoresQue10() {
        ContaMaluca matematica = new ContaMaluca();
        Assert.assertEquals(5*2, matematica.conta(5));
    }
}
