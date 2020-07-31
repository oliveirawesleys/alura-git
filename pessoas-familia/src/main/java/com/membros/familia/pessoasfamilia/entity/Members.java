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
public class Members {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;
    private String city;
    private Long cpf;
    private LocalDate born;

    public Members(String name, Integer age, Long cpf, LocalDate born) {
        this.name = name;
        this.age = age;
        this.cpf = cpf;
        this.born = born;
    }
}
