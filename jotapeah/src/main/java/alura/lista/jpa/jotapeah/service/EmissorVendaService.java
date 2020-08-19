package alura.lista.jpa.jotapeah.service;

import alura.lista.jpa.jotapeah.exception.EmissorVendaExcpetion;
import alura.lista.jpa.jotapeah.exception.SistemaERPExcpetion;
import alura.lista.jpa.jotapeah.model.Venda;
import alura.lista.jpa.jotapeah.modelo.VendaDTO;
import org.springframework.stereotype.Service;

@Service
public class EmissorVendaService {

    private SistemaERPProxyService sistemaERPProxyService;

    public EmissorVendaService(SistemaERPProxyService sistemaERPProxyService) {
        this.sistemaERPProxyService = sistemaERPProxyService;
    }

    public void emitir(Venda venda) throws EmissorVendaExcpetion {
        VendaDTO vendaDTO = createDTO(venda);
        try {
            sistemaERPProxyService.emitir(vendaDTO);
        } catch (SistemaERPExcpetion e) {
            throw new EmissorVendaExcpetion(e);
        }
    }

    private VendaDTO createDTO(Venda venda) {
        VendaDTO vendaDTO = new VendaDTO();
        vendaDTO.setValorImposto(venda.getValorComissao());
        vendaDTO.setValorTotal(venda.getValorTotal());
        return vendaDTO;
    }
}
