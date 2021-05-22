package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BonusServiceTest {

    @Test
    public void bonusDeveriaSerZeroParaUmFuncionarioComSalarioMuitoAlto() {
        //prepara
        BonusService bonusService = new BonusService();
        Funcionario funcionario = new Funcionario("Chaves", LocalDate.now(), new BigDecimal("23000"));

        BigDecimal valorBonus = bonusService.calcularBonus(funcionario);

        Assert.assertEquals(BigDecimal.ZERO, valorBonus);
    }

    @Test
    public void bonusDeveriaSerDezPorCentoDoSalario() {
        //prepara
        BonusService bonusService = new BonusService();
        Funcionario funcionario = new Funcionario("Quico", LocalDate.now(), new BigDecimal("2300"));

        BigDecimal valorBonus = bonusService.calcularBonus(funcionario);

        Assert.assertEquals(new BigDecimal("230.0"), valorBonus);
    }

    @Test
    public void bonusDeveriaSerDezPorcentoParaSalarioDeExatamenteDezMil() {
        //prepara
        BonusService bonusService = new BonusService();
        Funcionario funcionario = new Funcionario("Chiquinha", LocalDate.now(), new BigDecimal("10000"));
        BigDecimal valorBonus = bonusService.calcularBonus(funcionario);

        Assert.assertEquals(new BigDecimal("1000.0"), valorBonus);
    }
}
