package br.com.alura.listavip;

import br.com.alura.listavip.model.Destino;
import br.com.alura.listavip.repository.DestinoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
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
