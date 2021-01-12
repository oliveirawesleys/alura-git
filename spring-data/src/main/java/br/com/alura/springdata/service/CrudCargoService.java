package br.com.alura.springdata.service;

import br.com.alura.springdata.orm.Cargo;
import br.com.alura.springdata.repository.CargoRepository;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CrudCargoService {

    private Boolean system = true;
    private final CargoRepository cargoRepository;

    public CrudCargoService(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
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
        System.out.println("Insira a descrição do cargo:");
        String descricao = scanner.next();

        Cargo cargo = new Cargo();
        cargo.setDescricao(descricao);

        cargoRepository.save(cargo);
        System.out.println("Salvo com sucesso!");
    }

    public void atualizar(Scanner scanner) {
        System.out.println("Insira o id a ser atualizado:");
        int id = scanner.nextInt();
        System.out.println("Insira a descrição do cargo:");
        String descricao = scanner.next();

        Cargo cargo = new Cargo();
        cargo.setId(id);
        cargo.setDescricao(descricao);

        cargoRepository.save(cargo);
        System.out.println("Atualizado com sucesso!");
    }

    public void listar() {
        Iterable<Cargo> cargos = cargoRepository.findAll();
        cargos.forEach(cargo -> System.out.println(cargo));
    }

    public void deletar(Scanner scanner) {
        System.out.println("Insira o id a ser deletado:");
        int id = scanner.nextInt();

        cargoRepository.deleteById(id);
        System.out.println("Deletado com sucesso!");
    }
}
