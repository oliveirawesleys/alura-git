package com.algaworks.osworks.osworksapi.domain.repository;

import com.algaworks.osworks.osworksapi.domain.model.OrdemServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long> {
}
