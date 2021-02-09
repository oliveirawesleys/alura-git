package com.learning.java.eight.javaeight;

import java.util.*;
import java.util.stream.Collectors;
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

        OptionalDouble media = cursos.stream()
                .filter(c -> c.getAlunos() > 50)
                .mapToInt(Curso::getAlunos)
                .average();

/*        cursos.stream()
                .filter(c -> c.getAlunos() > 110)
                .map(Curso::getNome)
                .forEach(System.out::println);*/
        //.forEach(System.out::println);

        //Assim podemos trabalhar em paralelo, para casos de grandes processamentos
        //cursos.parallelStream()
        /*cursos.stream()
                .filter(c -> c.getAlunos() > 100)
                .collect(Collectors.toMap(
                        c -> c.getNome(),
                        c -> c.getAlunos()))
                .forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos."));*/

        OptionalDouble qtdMedia = cursos.stream()
                .mapToInt(c -> c.getAlunos())
                .average();

        System.out.println("A quantidade média é: " + qtdMedia.getAsDouble());

        List<Curso> listaCursos = cursos.stream()
                .filter(curso -> curso.getAlunos() > 50)
                .collect(Collectors.toList());

        System.out.println(listaCursos.get(0).getNome());


        cursos.stream()
                .filter(curso -> curso.getAlunos() > 50)
                .collect(Collectors.toMap(
                        c -> c.getNome(),
                        c -> c.getAlunos()))
                .forEach((nome, aluno) -> System.out.println(nome + " " + aluno));

    }
}
