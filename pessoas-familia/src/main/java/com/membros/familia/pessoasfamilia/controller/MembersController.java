package com.membros.familia.pessoasfamilia.controller;

import com.membros.familia.pessoasfamilia.dto.AggregateDto;
import com.membros.familia.pessoasfamilia.dto.MembersDto;
import com.membros.familia.pessoasfamilia.entity.Aggregate;
import com.membros.familia.pessoasfamilia.entity.Members;
import com.membros.familia.pessoasfamilia.form.AggregateForm;
import com.membros.familia.pessoasfamilia.form.MembersForm;
import com.membros.familia.pessoasfamilia.form.RefreshMembersForm;
import com.membros.familia.pessoasfamilia.repository.AggregateRepository;
import com.membros.familia.pessoasfamilia.repository.MembersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping({"/membros"})
public class MembersController {

    @Autowired
    private MembersRepository repository;

    @Autowired
    private AggregateRepository aggregateRepository;


    @GetMapping
    public List<MembersDto> listMembers() {
        List<Members> members = repository.findAll();
        return MembersDto.convert(members);
    }


    @GetMapping(path = {"/{id}"})
    public ResponseEntity listEspecific(@PathVariable Long id) {
       return repository.findById(id)
                .map(member -> ResponseEntity.ok().body(member))
                .orElse(ResponseEntity.notFound().build());
    }



    @PostMapping
    public ResponseEntity<MembersDto> newMember(@RequestBody @Valid MembersForm memberForm, UriComponentsBuilder uriBuilder) {
        Members newMember = memberForm.converter();
        repository.save(newMember);
        URI uri = uriBuilder.path("/membros/{id}").buildAndExpand(newMember.getId()).toUri();
        return ResponseEntity.created(uri).body(new MembersDto(newMember));
    }
    @PostMapping("/aggregate")
    public Members oldAggregate(@RequestBody @Valid AggregateForm aggregateForm) {
        Members newAggregate =  new Members(aggregateForm.getName(), aggregateForm.getAge(), 0L,
                aggregateForm.getCity(), aggregateForm.getBorn());
        return repository.save(newAggregate);
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
