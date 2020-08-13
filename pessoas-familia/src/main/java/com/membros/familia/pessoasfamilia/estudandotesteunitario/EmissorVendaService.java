package com.membros.familia.pessoasfamilia.estudandotesteunitario;

import org.springframework.stereotype.Service;

@Service
public class EmissorVendaService {

    private SistemaERPProxyService sistemaERPProxyService;

    public EmissorVendaService(SistemaERPProxyService sistemaERPProxyService) {
        this.sistemaERPProxyService = sistemaERPProxyService;
    }

    public void emitir(Venda venda) throws Exception {
        VendaDTO vendaDTO = createDTO(venda);
        try {
            sistemaERPProxyService.emitir(vendaDTO);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }


    private VendaDTO createDTO(Venda venda) {
        VendaDTO vendaDTO = new VendaDTO();
        vendaDTO.setValorImposto(venda.getValorComissao());
        vendaDTO.setValorTotal(venda.getValorTotal());
        return vendaDTO;
    }
}
