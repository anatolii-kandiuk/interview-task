package com.interviewtask.service;

import com.interviewtask.dto.PersonDto;
import com.interviewtask.model.Person;
import com.interviewtask.repository.PersonRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public void createPerson(Person person) {
        this.personRepository.save(person);
    }

    public PersonDto getPersonById(Long id) {

        Person person = personRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Person not found"));

        return new PersonDto(person.getFirstName(), person.getLastName(), calculateAge(person.getDateOfBirth()));
    }

    private int calculateAge(LocalDate birthDate) {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

}
