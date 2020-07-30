package br.com.alura.jpa.modelo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Conta {

    @Id
    @GeneratedValue()
    private Long id;
    private Integer agencia;
    private Integer numero;
    private String titular;
}
