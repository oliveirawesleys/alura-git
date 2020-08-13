package com.membros.familia.pessoasfamilia.form;

import com.membros.familia.pessoasfamilia.entity.Aggregate;
import com.membros.familia.pessoasfamilia.entity.Members;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AggregateForm {

    @NotEmpty
    private String name;
    @NotNull
    private Integer age;
    private String city;
    private Long cpf;
    private LocalDate born;

}
