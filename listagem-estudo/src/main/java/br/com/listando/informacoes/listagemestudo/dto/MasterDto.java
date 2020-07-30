package br.com.listando.informacoes.listagemestudo.dto;

import br.com.listando.informacoes.listagemestudo.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MasterDto {
    private String nome;
    private LocalDate nascimento;
    private String email;

    public MasterDto(Usuario usuario) {
        this.nome = usuario.getNome();
        this.nascimento = usuario.getNascimento();
        this.email = usuario.getEmail();
    }

}
