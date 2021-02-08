package com.learning.java.eight.javaeight;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Curso {

    private String nome;
    private int alunos;

    public Curso(String nome, int alunos) {
        this.nome = nome;
        this.alunos = alunos;
    }

    public String getNome() {
        return nome;
    }

    public int getAlunos() {
        return alunos;
    }
}

class ExemploAlunos {
    public static void main(String[] args) {
        List<Curso> cursos = new ArrayList<Curso>();
        cursos.add(new Curso("Python", 45));
        cursos.add(new Curso("JavaScript", 150));
        cursos.add(new Curso("Java 8", 113));
        cursos.add(new Curso("C", 55));

        cursos.sort(Comparator.comparing(Curso::getAlunos));

        //cursos.forEach(c -> System.out.println(c.getNome()));

        Stream<String> nomes = cursos.stream().map(Curso::getNome);

        int sum = cursos.stream()
                .filter(c -> c.getAlunos() > 50)
                .mapToInt(Curso::getAlunos)
                .sum();

        System.out.println("A soma é: " + sum);

        cursos.stream()
                .filter(c -> c.getAlunos() > 110)
                .map(Curso::getNome)
                .forEach(System.out::println);
        //.forEach(System.out::println);
    }
}
