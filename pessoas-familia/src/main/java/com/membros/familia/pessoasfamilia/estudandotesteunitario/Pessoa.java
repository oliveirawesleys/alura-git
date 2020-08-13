package com.membros.familia.pessoasfamilia.estudandotesteunitario;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Pessoa {

    @Id
    private Long id;
    private String nome;
    private String email;
}
