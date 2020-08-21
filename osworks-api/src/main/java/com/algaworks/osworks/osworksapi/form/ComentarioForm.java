package com.algaworks.osworks.osworksapi.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ComentarioForm {

    @NotBlank
    private String descricao;

}
