package com.membros.familia.pessoasfamilia.form;

import com.membros.familia.pessoasfamilia.entity.Members;
import lombok.Data;

import java.time.LocalDate;

@Data
public class MembersForm {

    private String name;
    private Integer age;
    private String city;
    private Long cpf;
    private LocalDate born;

    public Members converter() {
        return new Members(name, age, cpf, born);
    }
}
