package com.membros.familia.pessoasfamilia.form;

import com.membros.familia.pessoasfamilia.entity.Members;
import com.membros.familia.pessoasfamilia.repository.MembersRepository;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class RefreshMembersForm {

    @NotNull @NotEmpty @Length(min = 7)
    private String name;
    @NotNull @NotEmpty
    private String city;

}
