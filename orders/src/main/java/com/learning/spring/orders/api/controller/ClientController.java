package com.learning.spring.orders.api.controller;

import com.learning.spring.orders.domain.model.Client;
import com.learning.spring.orders.domain.repository.ClienteRepository;
import com.learning.spring.orders.domain.service.FormClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private FormClientService clientService;

    @GetMapping
    public List<Client> listClient() {
        return clienteRepository.findAll();
    }

    @GetMapping("/{clientId}")
    public ResponseEntity search(@PathVariable Long clientId) {
        Optional<Client> client = clienteRepository.findById(clientId);

        if (client.isPresent()) {
            return ResponseEntity.ok(client.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client addClient(@Valid @RequestBody Client newCliente) {
        return clientService.save(newCliente);
    }

    @PutMapping("/{clientId}")
    public ResponseEntity<Client> updateClient(@Valid @PathVariable Long clientId, @RequestBody Client client) {
        if (!clienteRepository.existsById(clientId)) {
            return ResponseEntity.notFound().build();
        }
        client.setId(clientId);
        client = clientService.save(client);

        return ResponseEntity.ok().body(client);
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<Void> remove(@PathVariable Long clientId) {
        if (!clienteRepository.existsById(clientId)) {
            return ResponseEntity.notFound().build();
        }
        clientService.remove(clientId);

        return ResponseEntity.noContent().build();
    }
}
