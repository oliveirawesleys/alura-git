package com.learning.spring.orders.api.controller;

import com.learning.spring.orders.domain.model.Client;
import com.learning.spring.orders.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.List;

@RestController
public class ClientController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/client")
    public List<Client> listClient() {
        return clienteRepository.findAll();
    }
}
