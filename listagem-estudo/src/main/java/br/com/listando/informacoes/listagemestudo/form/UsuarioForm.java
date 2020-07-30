package br.com.listando.informacoes.listagemestudo.form;

import br.com.listando.informacoes.listagemestudo.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class UsuarioForm {
    private String nome;
    private LocalDate nascimento;
    private String email;

    public Usuario converter() {
        return new Usuario(nome, nascimento, email);
    }
}
