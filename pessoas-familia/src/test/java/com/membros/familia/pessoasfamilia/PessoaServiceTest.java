package com.membros.familia.pessoasfamilia;

import com.membros.familia.pessoasfamilia.estudandotesteunitario.Pessoa;
import com.membros.familia.pessoasfamilia.estudandotesteunitario.PessoaRepository;
import com.membros.familia.pessoasfamilia.estudandotesteunitario.PessoaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class PessoaServiceTest {

    @InjectMocks
    private PessoaService pessoaService;

    @Mock
    private PessoaRepository pessoaRepository;

    @Test
    public void whenCallSalvaPessoa_thenRertunMethodSaveCall() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Nome Pessoa");
        pessoa.setEmail("pessoa@email.com");

        pessoaService.save(pessoa);

        verify(pessoaRepository, times(1)).save(pessoa);
    }

    @Test(expected = RuntimeException.class)
    public void whenParameterNull_thenReturnCamposObrigatorios() {
        Pessoa pessoa = new Pessoa();
        pessoaService.save(pessoa);
    }



}
