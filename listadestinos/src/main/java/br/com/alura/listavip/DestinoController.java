package br.com.alura.listavip;

import br.com.alura.listavip.model.Destino;
import br.com.alura.listavip.repository.DestinoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @PostMapping(value = "salvar")
    public String salvar(@RequestParam("pais") String pais, @RequestParam("cidade") String cidade,
                         @RequestParam("clima") String clima, Model model) {

        Destino novoDestino = new Destino(pais, cidade, clima);
        destinoRepository.save(novoDestino);
        Iterable<Destino> destinos = destinoRepository.findAll();

        model.addAttribute("destinos", destinos);
        return "listadestinos";
    }
}
