package br.com.listando.informacoes.listagemestudo.form;

import br.com.listando.informacoes.listagemestudo.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class MasterForm {
    private String nome;
    private LocalDate nascimento;
    private String email;

    public MasterForm(Usuario user) {
        this.nome = user.getNome();
        this.nascimento = user.getNascimento();
        this.email = user.getEmail();
    }
}
