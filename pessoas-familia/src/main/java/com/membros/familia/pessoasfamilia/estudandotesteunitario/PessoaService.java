package com.membros.familia.pessoasfamilia.estudandotesteunitario;

import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    private PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public void save (Pessoa pessoa) {
        validaCampos(pessoa);
        pessoaRepository.save(pessoa);
    }

    private void validaCampos(Pessoa pessoa) {
        if (pessoa.getEmail() == null || pessoa.getNome() == null)
            throw new RuntimeException("Campos obrigatórios!");
    }
}
