package com.interviewtask.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import com.interviewtask.dto.PersonDto;
import com.interviewtask.model.Person;
import com.interviewtask.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PersonRepository personRepository;

    @LocalServerPort
    private int port;

    @Test
    public void testGetPersonById() {
        //given
        Person person = new Person();
        person.setFirstName("John");
        person.setLastName("Doe");
        person.setDateOfBirth(LocalDate.of(1990, 1, 1));
        person = personRepository.save(person);

        //when
        ResponseEntity<PersonDto> response = restTemplate.getForEntity("http://localhost:" + port + "/" + person.getId(), PersonDto.class);

        //then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getFirstName()).isEqualTo("John");
        assertThat(response.getBody().getLastName()).isEqualTo("Doe");
        assertThat(response.getBody().getAge()).isEqualTo(33);
    }

}
