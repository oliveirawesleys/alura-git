package microservicefornecedor.fornecedor.controller;

import microservicefornecedor.fornecedor.model.InfoFornecedor;
import microservicefornecedor.fornecedor.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
public class InfoController {

    @Autowired
    private InfoService infoService;

    @RequestMapping("/{estado}")
    public InfoFornecedor getInfoPorEstado(@PathVariable String estado) {
        System.out.println(infoService.getInforPorEstado(estado));
        return infoService.getInforPorEstado(estado);
    }

}
