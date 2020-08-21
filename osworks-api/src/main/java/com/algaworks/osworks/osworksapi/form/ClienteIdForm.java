package com.algaworks.osworks.osworksapi.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ClienteIdForm {

    @NotNull
    private Long id;

}
