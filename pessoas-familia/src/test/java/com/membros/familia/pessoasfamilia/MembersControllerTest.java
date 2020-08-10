package com.membros.familia.pessoasfamilia;

import com.membros.familia.pessoasfamilia.controller.MembersController;
import com.membros.familia.pessoasfamilia.dto.MembersDto;
import com.membros.familia.pessoasfamilia.entity.Members;
import com.membros.familia.pessoasfamilia.form.MembersForm;
import com.membros.familia.pessoasfamilia.repository.MembersRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

@ExtendWith(SpringExtension.class)
public class MembersControllerTest {

    @InjectMocks
    private MembersController controller;

    @Mock
    private MembersRepository repository;

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



}
