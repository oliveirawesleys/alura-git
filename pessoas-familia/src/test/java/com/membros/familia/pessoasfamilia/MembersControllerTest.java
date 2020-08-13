package com.membros.familia.pessoasfamilia;

import com.membros.familia.pessoasfamilia.controller.MembersController;
import com.membros.familia.pessoasfamilia.dto.MembersDto;
import com.membros.familia.pessoasfamilia.entity.Members;
import com.membros.familia.pessoasfamilia.repository.MembersRepository;
import javassist.compiler.ast.Member;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
public class MembersControllerTest {

    @InjectMocks
    private MembersController controller;

    @Mock
    private MembersRepository repository;

    @Mock
    private MembersDto membersDto;

    @Before
    public void setup() {
        MockMvcBuilders.standaloneSetup(this.controller);
    }

    @Test
    public void whenListMembersEmpty_thenEmpty() {
        List<MembersDto> membersList = this.controller.listMembers();
        Assert.assertTrue(membersList.isEmpty());
    }

    @Test
    public void whenListEspecificNull_thenNull() {
        Mockito.when(this.controller.listEspecific(null)).thenReturn(null);
    }


    @Test
    public void whenUpdate_thenNull() {
        Mockito.when(this.controller.update( null, null)).thenReturn(null);
    }

    @Test
    public void whenDelete_thenNull() {
        Mockito.when(this.controller.delete( null)).thenReturn(null);
    }

    @Test
    public void whenListAllMembers_thenListAllMembers() {
        Members memberOne = new Members("One", 1212, 1212L, "First", LocalDate.now());
        Members memberTwo = new Members("Two", 3434, 3434L, "Second", LocalDate.now());
        List<Members> listMembers = new ArrayList<>();
        listMembers.add(memberOne);
        listMembers.add(memberTwo);

        membersDto.convert(listMembers);
        controller.listMembers();
        Mockito.verify(repository, Mockito.times(1)).findAll();
    }
//Cenario

//Ação

//Verificação

}
