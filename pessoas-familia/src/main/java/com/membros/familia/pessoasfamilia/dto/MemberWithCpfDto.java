package com.membros.familia.pessoasfamilia.dto;

import com.membros.familia.pessoasfamilia.entity.Members;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MemberWithCpfDto {

    private String name;
    private Long cpf;

    public MemberWithCpfDto(Members member) {
        this.name = member.getName();
        this.cpf = member.getCpf();
    }
}
