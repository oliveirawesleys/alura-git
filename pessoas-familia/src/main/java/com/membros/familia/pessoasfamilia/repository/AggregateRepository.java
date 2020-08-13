package com.membros.familia.pessoasfamilia.repository;

import com.membros.familia.pessoasfamilia.entity.Aggregate;
import com.membros.familia.pessoasfamilia.entity.Members;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface AggregateRepository extends JpaRepository<Aggregate, Long> {

}
