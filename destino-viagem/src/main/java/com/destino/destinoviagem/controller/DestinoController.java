package com.destino.destinoviagem.controller;

import com.destino.destinoviagem.model.Destino;
import com.destino.destinoviagem.repository.DestinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/students"})
public class DestinoController {

    private DestinoRepository destinoRepository;

    public DestinoController(DestinoRepository destinoRepository) {
        this.destinoRepository = destinoRepository;
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("listadestinos")
    public String listaDestinos(Model model) {
        Iterable<Destino> destinos = destinoRepository.findAll();
        model.addAttribute("destinos", destinos);
        return "listadestinos";
    }
}