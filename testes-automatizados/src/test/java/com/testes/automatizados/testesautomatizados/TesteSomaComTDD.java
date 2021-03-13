package com.testes.automatizados.testesautomatizados;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TesteSomaComTDD {

    @Test
    public void soma() {
        Calculadora calculadora = new Calculadora();
        int num1 = 2;
        int num2 = 2;

        int resultado = calculadora.soma(num1, num2);

        assertEquals(4, resultado);

    }
}
