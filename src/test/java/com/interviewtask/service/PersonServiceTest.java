package com.interviewtask.service;

import com.interviewtask.dto.PersonDto;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import com.interviewtask.model.Person;
import com.interviewtask.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    @Test
    public void testGetPersonById() {
        //given
        long id = 1L;

        Person person = new Person();
        person.setId(id);
        person.setFirstName("John");
        person.setLastName("Doe");
        person.setDateOfBirth(LocalDate.of(1990, 1, 1));

        when(personRepository.findById(id)).thenReturn(Optional.of(person));

        //when
        PersonDto personDto = personService.getPersonById(id);

        //then
        assertThat(personDto.getFirstName()).isEqualTo("John");
        assertThat(personDto.getLastName()).isEqualTo("Doe");
        assertThat(personDto.getAge()).isEqualTo(33);
    }

}