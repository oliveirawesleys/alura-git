package br.com.listando.informacoes.listagemestudo.repository;

import br.com.listando.informacoes.listagemestudo.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query(value = "SELECT * FROM Usuario t WHERE t.nascimento > :dataNascimento", nativeQuery = true)
    List<Usuario> buscaDataNascimento(@Param("dataNascimento") LocalDate data);
}
