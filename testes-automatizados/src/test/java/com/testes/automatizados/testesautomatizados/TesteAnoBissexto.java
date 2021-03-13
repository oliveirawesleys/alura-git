package com.testes.automatizados.testesautomatizados;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TesteAnoBissexto {

    @Test
    public void deveRertornarAnoBissexto() {
        AnoBissexto anoBissexto = new AnoBissexto();

        assertEquals(true, anoBissexto.ehBissexto(2000));
        assertEquals(true, anoBissexto.ehBissexto(2016));
    }

    @Test
    public void naoDeveRetornarAnoBissexto() {
        AnoBissexto anoBissexto = new AnoBissexto();

        assertEquals(false, anoBissexto.ehBissexto(2011));
        assertEquals(false, anoBissexto.ehBissexto(2100));
    }
}
