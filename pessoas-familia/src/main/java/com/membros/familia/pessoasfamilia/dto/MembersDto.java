package com.membros.familia.pessoasfamilia.dto;

import com.membros.familia.pessoasfamilia.entity.Members;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MembersDto {

    private String name;
    private Integer age;
    private String city;
    private LocalDate born;

    public MembersDto(Members members) {
        this.name = members.getName();
        this.age = members.getAge();
        this.city = members.getCity();
        this.born = members.getBorn();
    }

    public static List<MembersDto> convert (List<Members> membersList) {
        return membersList.stream().map(MembersDto::new).collect(Collectors.toList());
    }
}
