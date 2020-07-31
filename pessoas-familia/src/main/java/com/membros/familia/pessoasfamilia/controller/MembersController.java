package com.membros.familia.pessoasfamilia.controller;

import com.membros.familia.pessoasfamilia.dto.MembersDto;
import com.membros.familia.pessoasfamilia.entity.Members;
import com.membros.familia.pessoasfamilia.form.MembersForm;
import com.membros.familia.pessoasfamilia.repository.MembersRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/membros"})
public class MembersController {

    private MembersRepository repository;

    public MembersController(MembersRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    private List<MembersDto> listMembers() {
        List<Members> members = repository.findAll();
        return MembersDto.convert(members);
    }

    @GetMapping(path = {"/{id}"})
    private ResponseEntity listEspecific(@PathVariable Long id) {
       return repository.findById(id)
                .map(member -> ResponseEntity.ok().body(member))
                .orElse(ResponseEntity.notFound().build());
    }

    //@GetMapping(path = {"/{name}"})
    private ResponseEntity searchName(@PathVariable String name) {
        return repository.findByName(name)
                .map(m -> ResponseEntity.ok().body(m))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    private void create(@RequestBody MembersForm memberForm) {
        Members newMember = memberForm.converter();
        repository.save(newMember);
    }
}
