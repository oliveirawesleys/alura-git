package br.com.alura.springdata.service;

import br.com.alura.springdata.orm.Cargo;
import br.com.alura.springdata.orm.UnidadeTrabalho;
import br.com.alura.springdata.repository.UnidadeTrabalhoRepository;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CrudUnidadeTrabalhoService {

    private Boolean system = true;
    private final UnidadeTrabalhoRepository unidadeTrabalhoRepository;

    public CrudUnidadeTrabalhoService(UnidadeTrabalhoRepository unidadeTrabalhoRepository) {
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
        System.out.println("Insira o nome da unidade:");
        String descricao = scanner.next();

        UnidadeTrabalho unidadeTrabalho = new UnidadeTrabalho();
        unidadeTrabalho.setDescricao(descricao);

        unidadeTrabalhoRepository.save(unidadeTrabalho);
        System.out.println("Salvo com sucesso!");
    }

    public void atualizar(Scanner scanner) {
        System.out.println("Insira o id a ser atualizado:");
        int id = scanner.nextInt();
        System.out.println("Insira o nome da unidade:");
        String descricao = scanner.next();

        UnidadeTrabalho unidadeTrabalho = new UnidadeTrabalho();
        unidadeTrabalho.setId(id);
        unidadeTrabalho.setDescricao(descricao);

        unidadeTrabalhoRepository.save(unidadeTrabalho);
        System.out.println("Atualizado com sucesso!");
    }

    public void listar() {
        Iterable<UnidadeTrabalho> unidades = unidadeTrabalhoRepository.findAll();
        unidades.forEach(unidadeTrabalho -> System.out.println(unidadeTrabalho));
    }

    public void deletar(Scanner scanner) {
        System.out.println("Insira o id a ser deletado:");
        int id = scanner.nextInt();

        unidadeTrabalhoRepository.deleteById(id);
        System.out.println("Deletado com sucesso!");
    }
}
