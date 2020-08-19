package alura.lista.jpa.jotapeah.service;

import alura.lista.jpa.jotapeah.model.Pessoa;
import alura.lista.jpa.jotapeah.repository.PessoaRepository;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    private PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public void save(Pessoa pessoa) {
        validaCampos(pessoa);
        pessoaRepository.save(pessoa);
    }

    private void validaCampos(Pessoa pessoa) {
        if (pessoa.getNome() == null || pessoa.getEmail() == null)
            throw new RuntimeException("Campos obrigátorios!");
    }
}
