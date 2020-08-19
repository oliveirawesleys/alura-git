package com.algaworks.osworks.osworksapi.controller;

import com.algaworks.osworks.osworksapi.domain.model.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ClienteController {

    @GetMapping("/clientes")
    public List<Cliente> listar() {
        var cliente1 = new Cliente();
        cliente1.setId(1l);
        cliente1.setNome("Joao Silva");
        cliente1.setTelefone("34 4433-2211");
        cliente1.setEmail("joao@email.com");

        var cliente2 = new Cliente();
        cliente2.setId(2l);
        cliente2.setNome("Maria");
        cliente2.setTelefone("11 1122-5566");
        cliente2.setEmail("maria@email.com");

        return Arrays.asList(cliente1, cliente2);
    }
}
