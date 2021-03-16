package com.testes.automatizados.testesautomatizados;

import org.junit.Before;
import org.junit.Test;

public class LanceTest {

    private Usuario joao;

    @Before
    public void setTup() {
        System.out.println("Inicio do teste!");
        this.joao = new Usuario("Joao");
    }

    @Test(expected = IllegalArgumentException.class)
    public void naoDevePermitirLanceMenoreQueZero() {
        Lance lance = new Lance(joao, -10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void naoDevePermitirLanceIgualZero() {
        Lance lance = new Lance(joao, -10);
    }
}
