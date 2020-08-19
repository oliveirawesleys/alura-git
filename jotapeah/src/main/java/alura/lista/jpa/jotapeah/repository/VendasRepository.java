package alura.lista.jpa.jotapeah.repository;

import alura.lista.jpa.jotapeah.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VendasRepository extends JpaRepository {
    List<Venda> findByCpfAndPeriodo(String cpf, Integer periodo);
}
