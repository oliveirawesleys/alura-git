package com.membros.familia.pessoasfamilia.estudandotesteunitario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface VendaRepository extends JpaRepository <Venda, BigDecimal> {
    List<Venda> findByCpfAndPeriodo(String cpf, Integer periodo);
}
