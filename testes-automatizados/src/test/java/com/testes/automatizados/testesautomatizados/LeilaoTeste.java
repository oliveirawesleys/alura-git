package com.testes.automatizados.testesautomatizados;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeilaoTeste {

    @Test
    public void deveReceberUmLance() {
        Leilao leilao = new Leilao("Macbook");

        assertEquals(0, leilao.getLances().size());

        leilao.propoe(new Lance(new Usuario("Steve"), 1000));
        assertEquals(1, leilao.getLances().size());
        assertEquals(1000, leilao.getLances().get(0).getValor(), 0.00001);
    }

    @Test
    public void deveReceberVariosLances() {
        Leilao leilao = new Leilao("Macbook");
        leilao.propoe(new Lance(new Usuario("Tonico"), 12000));
        leilao.propoe(new Lance(new Usuario("Zebubu"), 5000));

        assertEquals(2, leilao.getLances().size());
        assertEquals(12000, leilao.getLances().get(0).getValor(), 0.00001);
        assertEquals(5000, leilao.getLances().get(1).getValor(), 0.00001);

    }

    @Test
    public void naoDeveAceitarDoisLancesSeguidosDoMesmoUsuario() {
        Leilao leilao = new Leilao("Macbook");
        Usuario lolo = new Usuario("Lolo");

        leilao.propoe(new Lance(lolo, 2000));
        leilao.propoe(new Lance(lolo, 4000));

        assertEquals(1, leilao.getLances().size());
        assertEquals(2000, leilao.getLances().get(0).getValor(), 0.00001);

    }

    @Test
    public void naoDeveReceberMaisQue5LancesDoMesmoUsuario() {
        Leilao leilao = new Leilao("TV");
        Usuario BA = new Usuario("BA");
        Usuario AA = new Usuario("AA");

        leilao.propoe(new Lance(BA, 100));
        leilao.propoe(new Lance(AA, 200));

        leilao.propoe(new Lance(BA, 300));
        leilao.propoe(new Lance(AA, 400));

        leilao.propoe(new Lance(BA, 500));
        leilao.propoe(new Lance(AA, 600));

        leilao.propoe(new Lance(BA, 700));
        leilao.propoe(new Lance(AA, 800));

        leilao.propoe(new Lance(BA, 900));
        leilao.propoe(new Lance(AA, 1000));

        leilao.propoe(new Lance(BA, 550));

        assertEquals(10, leilao.getLances().size());
        assertEquals(1000, leilao.getLances().get(leilao.getLances().size()-1).getValor(), 0.0001);

    }
}
