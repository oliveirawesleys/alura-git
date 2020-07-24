package br.com.listando.informacoes.listagemestudo.controller;

import br.com.listando.informacoes.listagemestudo.entity.Usuario;
import br.com.listando.informacoes.listagemestudo.repository.UsuarioRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    @PostMapping("/adiciona")
    public Usuario adiciona(@RequestBody Usuario usuarioNovo) {
        return repository.save(usuarioNovo);
    }

    @PutMapping("/atualiza")
    public ResponseEntity atualiza(long id, @RequestBody Usuario usuario) {
        System.out.println(id);
        return repository.findById(id)
                .map(novo -> {
                    novo.setNome(usuario.getNome());
                    novo.setEmail(usuario.getEmail());
                    novo.setNascimento(usuario.getNascimento());
                    Usuario usuarioNovo = repository.save(novo);
                    return ResponseEntity.ok().body(usuarioNovo);
                }).orElse(ResponseEntity.notFound().build());
    }

}
