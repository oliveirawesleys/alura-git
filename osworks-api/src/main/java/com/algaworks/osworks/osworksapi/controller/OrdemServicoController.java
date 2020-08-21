package com.algaworks.osworks.osworksapi.controller;

import com.algaworks.osworks.osworksapi.domain.model.OrdemServico;
import com.algaworks.osworks.osworksapi.domain.repository.OrdemServicoRepository;
import com.algaworks.osworks.osworksapi.domain.service.GestaoOrdemServicoService;
import com.algaworks.osworks.osworksapi.form.OrdemServicoForm;
import com.algaworks.osworks.osworksapi.model.OrdemServicoModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ordens-servico")
public class OrdemServicoController {

    @Autowired
    private GestaoOrdemServicoService gestaoOrdemServicoService;

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrdemServicoModel criar(@RequestBody @Valid OrdemServicoForm ordemServicoForm) {
        OrdemServico ordemServico = toEntity(ordemServicoForm);

        return toModel(gestaoOrdemServicoService.criar(ordemServico));
    }

    @GetMapping
    public List<OrdemServicoModel> listar() {
        return toCollectionModel(ordemServicoRepository.findAll());
    }

    @GetMapping("/{ordemServicoId}")
    public ResponseEntity<OrdemServicoModel> buscar (@PathVariable Long ordemServicoId) {
        Optional<OrdemServico> ordemServico = ordemServicoRepository.findById(ordemServicoId);

        if (ordemServico.isPresent()) {
            OrdemServicoModel ordemServicoModel = toModel(ordemServico.get());
            return ResponseEntity.ok().body(ordemServicoModel);
        }
        return ResponseEntity.notFound().build();
    }

    private OrdemServicoModel toModel(OrdemServico ordemServico) {
        return modelMapper.map(ordemServico, OrdemServicoModel.class);
    }

    private List<OrdemServicoModel> toCollectionModel(List<OrdemServico> ordensServico) {
        return ordensServico.stream()
                .map(ordemServico -> toModel(ordemServico))
                .collect(Collectors.toList());
    }

    private OrdemServico toEntity(OrdemServicoForm ordemServicoForm) {
        return modelMapper.map(ordemServicoForm, OrdemServico.class);
    }
}
