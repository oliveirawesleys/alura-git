package com.membros.familia.pessoasfamilia.controller;

import com.membros.familia.pessoasfamilia.dto.MembersDto;
import com.membros.familia.pessoasfamilia.entity.Members;
import com.membros.familia.pessoasfamilia.form.MembersForm;
import com.membros.familia.pessoasfamilia.form.RefreshMembersForm;
import com.membros.familia.pessoasfamilia.repository.MembersRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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

/*    @GetMapping("/{id}")
    private ResponseEntity detail(@PathVariable Long id) {
        return repository.findById(id)
                .map(m -> {
                    m.getName();
                    m.getCpf();
                    MembersDto mem = new MembersDto(m);
                    return ResponseEntity.ok().body(mem);
                }).orElse(ResponseEntity.notFound().build());
    }*/



    //@GetMapping(path = {"/{name}"})
    private ResponseEntity searchName(@PathVariable String name) {
        return repository.findByName(name)
                .map(m -> ResponseEntity.ok().body(m))
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    private ResponseEntity<MembersDto> newMember(@RequestBody @Valid MembersForm memberForm, UriComponentsBuilder uriBuilder) {
        Members newMember = memberForm.converter();
        repository.save(newMember);
        URI uri = uriBuilder.path("/membros/{id}").buildAndExpand(newMember.getId()).toUri();
        return ResponseEntity.created(uri).body(new MembersDto(newMember));
    }

    //@PutMapping("/{id}")
    public ResponseEntity<MembersDto> refresh(@PathVariable Long id, @RequestBody @Valid RefreshMembersForm form) {
        Members member = form.atualizar(id, repository);
        return ResponseEntity.ok(new MembersDto(member));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody @Valid RefreshMembersForm member) {
        return repository.findById(id)
                .map(m -> {
                    m.setName(member.getName());
                    //m.setAge(member.getAge());
                    //m.setCpf(member.getCpf());
                    m.setCity(member.getCity());
                    //m.setBorn(member.getBorn());
                    Members updated = repository.save(m);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        return repository.findById(id)
                .map(m -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
