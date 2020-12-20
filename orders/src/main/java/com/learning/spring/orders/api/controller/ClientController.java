package com.learning.spring.orders.api.controller;

import com.learning.spring.orders.domain.model.Client;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ClientController {

    @GetMapping("/client")
    public List<Client> listClient() {
        Client client1 = new Client();
        client1.setId(1L);
        client1.setName("João");
        client1.setPhone("11 97766-5544");
        client1.setEmail("joao@email.com");

        Client client2 = new Client();
        client2.setId(2L);
        client2.setName("Maria");
        client2.setPhone("11 99988-7766");
        client2.setEmail("maria@email.com");

        return Arrays.asList(client1, client2);
    }
}
