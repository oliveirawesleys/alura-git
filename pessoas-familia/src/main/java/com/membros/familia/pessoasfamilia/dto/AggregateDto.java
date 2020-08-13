package com.membros.familia.pessoasfamilia.dto;

import com.membros.familia.pessoasfamilia.entity.Aggregate;
import com.membros.familia.pessoasfamilia.entity.Members;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AggregateDto {

    private String name;
    private Integer age;
    private String city;
    private LocalDate born;

    public AggregateDto(Aggregate aggregate) {
        this.name = aggregate.getName();
        this.age = aggregate.getAge();
        this.city = aggregate.getCity();
        this.born = aggregate.getBorn();
    }

    public static List<AggregateDto> convert (List<Aggregate> aggregateList) {
        return aggregateList.stream().map(AggregateDto::new).collect(Collectors.toList());
    }
}
