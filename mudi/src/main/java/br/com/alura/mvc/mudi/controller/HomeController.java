package br.com.alura.mvc.mudi.controller;

import br.com.alura.mvc.mudi.model.Pedido;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Model model) {
        Pedido pedido = new Pedido();
        pedido.setNomeProduto("Kindle 10a. geração com iluminação embutida");
        pedido.setUrlImagem("https://images-na.ssl-images-amazon.com/images/I/61X0ISBpD-L._AC_SL1000_.jpg");
        pedido.setUrlProduto("https://www.amazon.com.br/gp/product/B07FQK1TS9?ref_=gw_ATF_kindle10agen&pf_rd_r=FFCX23ZPZTN05QT15MVE&pf_rd_p=d44a26cf-4845-48a7-adcb-020bc9ee760f&pd_rd_r=b07d5db0-a62d-4097-b24e-179f584ac870&pd_rd_w=iVQeN&pd_rd_wg=N3sgG");
        pedido.setDescricao("Uma descrição qualquer.");

        List<Pedido> pedidos = Arrays.asList(pedido);
        model.addAttribute("pedidos", pedidos);
        return "home";
    }
}
