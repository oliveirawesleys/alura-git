package com.algaworks.osworks.osworksapi.domain.repository;

import com.algaworks.osworks.osworksapi.domain.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
}
