package com.learning.java.eight.javaeight;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Datas {

    public static void main(String[] args) {
        LocalDate hoje = LocalDate.now();
        System.out.println("HOJE: " + hoje);

        LocalDate dataProximaCopa = LocalDate.of(2022, Month.JULY, 11);
        int anos = dataProximaCopa.getYear() - hoje.getYear();

        System.out.println(anos);

        Period periodo = Period.between(hoje, dataProximaCopa);

        LocalDate proximaCopa = dataProximaCopa.plusYears(4);

        System.out.println(proximaCopa);

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String valorFormatado = proximaCopa.format(formatador);
        System.out.println(valorFormatado);

        DateTimeFormatter formatadorComHora = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
        LocalDateTime agora = LocalDateTime.now();
        System.out.println(agora.format(formatadorComHora));

        LocalTime horaIntervalo = LocalTime.of(15, 30);
        System.out.println(horaIntervalo);

        LocalDate dataFixa = LocalDate.of(2099, Month.JANUARY, 25);
        DateTimeFormatter formatadorHoje = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFixaFormatada = dataFixa.format(formatadorHoje);
        System.out.println(dataFixaFormatada);

        Period period2 = Period.between(LocalDate.now(), dataFixa);
        System.out.println(period2);
    }
}
