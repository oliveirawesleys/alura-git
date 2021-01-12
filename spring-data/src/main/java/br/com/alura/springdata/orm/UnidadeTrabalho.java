package br.com.alura.springdata.orm;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "unidade_trabalho")
@Getter
@Setter
public class UnidadeTrabalho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String descricao;
    private String endereco;

    @ManyToMany(mappedBy = "unidade_trabalho", fetch = FetchType.EAGER)
    private List<Funcionario> funcionarios;

}
