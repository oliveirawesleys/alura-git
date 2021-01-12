package br.com.alura.springdata.orm;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "cargos")
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String descricao;

    @OneToMany(mappedBy = "cargo")
    private List<Funcionario> funcionario;

    @Override
    public String toString() {
        return "Cargo{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
