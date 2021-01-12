package br.com.alura.springdata.service;

import br.com.alura.springdata.orm.Cargo;
import br.com.alura.springdata.orm.Funcionario;
import br.com.alura.springdata.orm.UnidadeTrabalho;
import br.com.alura.springdata.repository.CargoRepository;
import br.com.alura.springdata.repository.FuncionarioReposiroty;
import br.com.alura.springdata.repository.UnidadeTrabalhoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class CrudFuncionarioService {

    private Boolean system = true;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    private final CargoRepository cargoRepository;
    private final FuncionarioReposiroty funcionarioRepository;
    private final UnidadeTrabalhoRepository unidadeTrabalhoRepository;

    public CrudFuncionarioService(CargoRepository cargoRepository, FuncionarioReposiroty funcionarioRepository,
                                  UnidadeTrabalhoRepository unidadeTrabalhoRepository) {
        this.cargoRepository = cargoRepository;
        this.funcionarioRepository = funcionarioRepository;
        this.unidadeTrabalhoRepository = unidadeTrabalhoRepository;
    }

    public void inicial(Scanner scanner) {
        while (system) {
            System.out.println("Qual ação de cargo deseja executar?");
            System.out.println("0 - Sair");
            System.out.println("1 - Salvar");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Listar");
            System.out.println("4 - Deletar");

            int action = scanner.nextInt();
            switch (action) {
                case 1:
                    salvar(scanner);
                    break;
                case 2:
                    atualizar(scanner);
                    break;
                case 3:
                    listar();
                    break;
                case 4:
                    deletar(scanner);
                    break;
                default:
                    system = false;
                    break;
            }

        }
    }

    public void salvar(Scanner scanner) {
        System.out.println("Insira o nome:");
        String nome = scanner.next();

        System.out.println("Insira o CPF:");
        String cpf = scanner.next();

        System.out.println("Insira o salário:");
        Double salario = scanner.nextDouble();

        System.out.println("Insira a data de contratação:");
        String dataContratacao = scanner.next();

        System.out.println("Insira o cargoId:");
        Integer cargoId = scanner.nextInt();

        List<UnidadeTrabalho> unidades = unidade(scanner);

        Funcionario funcionario = new Funcionario();
        funcionario.setNome(nome);
        funcionario.setCpf(cpf);
        funcionario.setSalario(salario);
        funcionario.setDataContratacao(LocalDate.parse(dataContratacao, formatter));
        Optional<Cargo> cargo = cargoRepository.findById(cargoId);
        funcionario.setCargo(cargo.get());
        funcionario.setUnidadeTrabalhos(unidades);

        funcionarioRepository.save(funcionario);
        System.out.println("Salvo com sucesso!");
    }

    private List<UnidadeTrabalho> unidade(Scanner scanner) {
        Boolean isTrue = true;
        List<UnidadeTrabalho> unidades = new ArrayList<>();

        while (isTrue) {
            System.out.println("Digite a unidadeId (Para sair digite 0)");
            Integer unidadeId = scanner.nextInt();

            if (unidadeId != 0) {
                Optional<UnidadeTrabalho> unidade = unidadeTrabalhoRepository.findById(unidadeId);
                unidades.add(unidade.get());
            } else {
                isTrue = false;
            }
        }
        return unidades;
    }

    private void atualizar(Scanner scanner) {
        System.out.println("Insira o id:");
        Integer id = scanner.nextInt();

        System.out.println("Insira o nome:");
        String nome = scanner.next();

        System.out.println("Insira o CPF:");
        String cpf = scanner.next();

        System.out.println("Insira o salário:");
        Double salario = scanner.nextDouble();

        System.out.println("Insira a data de contratação:");
        String dataContratacao = scanner.next();

        System.out.println("Insira o cargoId:");
        Integer cargoId = scanner.nextInt();

        Funcionario funcionario = new Funcionario();
        funcionario.setId(id);
        funcionario.setNome(nome);
        funcionario.setCpf(cpf);
        funcionario.setSalario(salario);
        funcionario.setDataContratacao(LocalDate.parse(dataContratacao, formatter));
        Optional<Cargo> cargo = cargoRepository.findById(cargoId);
        funcionario.setCargo(cargo.get());


        funcionarioRepository.save(funcionario);
        System.out.println("Alterado");
    }

    public void listar() {
        Iterable<Funcionario> funcionarios = funcionarioRepository.findAll();
        funcionarios.forEach(funcionario -> System.out.println(funcionario));
    }

    public void deletar(Scanner scanner) {
        System.out.println("Insira o id a ser deletado:");
        int id = scanner.nextInt();

        funcionarioRepository.deleteById(id);
        System.out.println("Deletado com sucesso!");
    }
}
