package br.com.alura.forum;

import br.com.alura.forum.modelo.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TopicoRepository extends JpaRepository <Topico, Long> {

    Page<Topico> findByCursoNome(String nomeCurso, Pageable paginacao);

//    @Query("SELECT T FROM TOPICO T WHERE T.CURSO.NOME = :nomeCurso")
//    List<Topico> carregarPorNomeDoCurso(@Param("nomeCurso") String nomeCurso);

}