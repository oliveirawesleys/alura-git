package br.com.alura.forum.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErroDeFormularioDTO {

    private String campo;
    private String erro;
}
