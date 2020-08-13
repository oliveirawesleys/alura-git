package com.membros.familia.pessoasfamilia.estudandotesteunitario;

import org.springframework.stereotype.Repository;

@Repository
public class SistemaERPProxyService {

    public VendaDTO emitir(VendaDTO vendaDTO) {
        vendaDTO.getValorImposto();
        vendaDTO.getValorTotal();
        return vendaDTO;
    }
}
