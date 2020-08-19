package com.membros.familia.pessoasfamilia.repository;

import com.membros.familia.pessoasfamilia.entity.Members;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
/*@Component
@PropertySource("classpath:queries.yml")*/
public interface MembersRepository extends JpaRepository<Members, Long> {

    Optional<Members> findByName(String name);

    @Query("SELECT t FROM Members t WHERE t.city = :cidade")
    //@SqlFromResource
    //@Value("${consulta}")
    List<Members> buscaCidade(@Param("cidade") String cidade);
}
