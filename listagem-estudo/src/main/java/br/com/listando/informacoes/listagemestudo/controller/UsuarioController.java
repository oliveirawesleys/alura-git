package br.com.listando.informacoes.listagemestudo.controller;

import br.com.listando.informacoes.listagemestudo.dto.UsuarioDto;
import br.com.listando.informacoes.listagemestudo.entity.Master;
import br.com.listando.informacoes.listagemestudo.entity.Usuario;
import br.com.listando.informacoes.listagemestudo.form.MasterForm;
import br.com.listando.informacoes.listagemestudo.form.UsuarioForm;
import br.com.listando.informacoes.listagemestudo.repository.MasterRepository;
import br.com.listando.informacoes.listagemestudo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private MasterRepository repositoryMaster;

/*    public UsuarioController() {


    UsuarioController(UsuarioRepository repository) {
        this.repository = repository;
    }

    UsuarioController(MasterRepository repositoryMaster) {
        this.repositoryMaster = repositoryMaster;
    }
*/

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

    @PostMapping("/adicionaOLD")
    public Usuario adiciona(@RequestBody Usuario usuarioNovo) {
        return repository.save(usuarioNovo);
    }

    @PostMapping("/adicionaMaster")
    public void adicionaMaster(@RequestBody Usuario usuario) {
        Master user = new Master(usuario);
        repositoryMaster.save(user);
    }

    @PostMapping("/adiciona")
    public ResponseEntity<UsuarioDto> adicionaDto(@RequestBody UsuarioForm usuarioForm, UriComponentsBuilder uriBuilder) {
        Usuario usuarioNovo = usuarioForm.converter();
        repository.save(usuarioNovo);
        URI uri = uriBuilder.path("/adiciona/{id}").buildAndExpand(usuarioNovo.getId()).toUri();
        return ResponseEntity.created(uri).body(new UsuarioDto(usuarioNovo));
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

    @RequestMapping(value = "/remover", method = RequestMethod.DELETE)
    public ResponseEntity<?> remover(long id) {
        return repository.findById(id)
                .map(usuario -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

}
