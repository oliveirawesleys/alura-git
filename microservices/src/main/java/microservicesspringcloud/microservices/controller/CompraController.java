package microservicesspringcloud.microservices.controller;

import microservicesspringcloud.microservices.dto.CompraDto;
import microservicesspringcloud.microservices.model.Compra;
import microservicesspringcloud.microservices.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compra")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @PostMapping
    public Compra realizaCompra(@RequestBody CompraDto compra) {
        return compraService.realizaCompra(compra);
    }
}
