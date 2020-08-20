package com.algaworks.osworks.osworksapi.domain.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(max=60)
    private String nome;
    @NotBlank
    @Email
    @Size(max=255)
    private String email;
    @NotBlank
    @Size(max=20)
    private String telefone;
}
