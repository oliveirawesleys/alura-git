package br.com.alura.springdata.repository;

import br.com.alura.springdata.orm.Funcionario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioReposiroty extends CrudRepository<Funcionario, Integer> {
}
