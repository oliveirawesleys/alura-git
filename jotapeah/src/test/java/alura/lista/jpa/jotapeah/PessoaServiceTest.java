package alura.lista.jpa.jotapeah;

import alura.lista.jpa.jotapeah.model.Pessoa;
import alura.lista.jpa.jotapeah.repository.PessoaRepository;
import alura.lista.jpa.jotapeah.service.PessoaService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class PessoaServiceTest {

    @InjectMocks
    PessoaService pessoaService;

    @Mock
    PessoaRepository pessoaRepository;

    @Test
    public void testSalvarComSucesso() {
        Pessoa pessoa = criaPessoa();
        pessoaService.save(pessoa);
        Mockito.verify(pessoaRepository, times(1)).save(pessoa);
    }

    @Test
    public void testNullPessoa() {
        Pessoa pessoa = new Pessoa();
        pessoaRepository.save(pessoa);
        Assert.assertNull(pessoa.getNome(), pessoa.getEmail());
    }

    @Test(expected = RuntimeException.class)
    public void testPessoaRuntimeException() {
        Pessoa pessoa = new Pessoa();
        pessoaService.save(pessoa);
    }

    private Pessoa criaPessoa() {
        Pessoa pessoaMock = new Pessoa();
        pessoaMock.setNome("Pessoa Mock");
        pessoaMock.setEmail("email@mock.com");
        return pessoaMock;
    }

}
