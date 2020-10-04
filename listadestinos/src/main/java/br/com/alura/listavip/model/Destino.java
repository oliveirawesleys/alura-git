package br.com.alura.listavip.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Destino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pais;
    private String cidade;
    private String clima;

    public Destino(String pais, String cidade, String clima) {
        this.pais = pais;
        this.cidade = cidade;
        this.clima = clima;
    }
}
