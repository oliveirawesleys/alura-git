package com.membros.familia.pessoasfamilia.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Aggregate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;
    private String city;
    private Long cpf;
    private LocalDate born;

    public Aggregate(String name, Integer age, Long cpf, String city, LocalDate born) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.cpf = cpf;
        this.born = born;
    }


}
