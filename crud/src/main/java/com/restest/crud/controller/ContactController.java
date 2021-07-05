package com.restest.crud.controller;

import com.restest.crud.repository.ContactRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    private ContactRepository repository;

    public ContactController(ContactRepository repository) {
        this.repository = repository;
    }

    
}
