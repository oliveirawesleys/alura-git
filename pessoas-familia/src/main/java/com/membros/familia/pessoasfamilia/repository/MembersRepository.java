package com.membros.familia.pessoasfamilia.repository;

import com.membros.familia.pessoasfamilia.entity.Members;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MembersRepository extends JpaRepository<Members, Long> {

    Optional<Members> findByName(String name);

    @Query("SELECT t FROM Members t WHERE t.city = :cidade")
    List<Members> buscaCidade(@Param("cidade") String cidade);
}
