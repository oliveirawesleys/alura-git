package com.learning.spring.orders.domain.service;

import com.learning.spring.orders.domain.exception.BusinessException;
import com.learning.spring.orders.domain.model.Client;
import com.learning.spring.orders.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormClientService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Client save(Client client) {
        Client clientExist = clienteRepository.findByEmail(client.getEmail());

        if (clientExist != null && !clientExist.equals(client)) {
            throw new BusinessException("Já existe um cliente com este email.");
        }

        return clienteRepository.save(client);
    }

    public void remove(Long clientId) {
        clienteRepository.deleteById(clientId);
    }

}
