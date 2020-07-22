package br.com.listando.informacoes.listagemestudo.controller;

import br.com.listando.informacoes.listagemestudo.entity.Usuario;
import br.com.listando.informacoes.listagemestudo.repository.UsuarioRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UsuarioController {

    private UsuarioRepository repository;

    UsuarioController(UsuarioRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/usuarios")
    public List listaTodosUsuarios() {
        return repository.findAll();
    }

    @RequestMapping("/usuario")
    public ResponseEntity buscaUsuario(long id) {
        return repository.findById(id)
                .map(registro -> ResponseEntity.ok().body(registro))
                .orElse(ResponseEntity.notFound().build());
    }

    @RequestMapping("/nascimento")
    public List<Usuario> procuraNascimento(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data) {
        return repository.buscaDataNascimento(data).stream().collect(Collectors.toList());
    }


}
