package com.interviewtask.service;

import com.interviewtask.model.Person;
import com.interviewtask.repository.PersonRepository;
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

    public Person getPersonById(Long id) {
        Person person = personRepository.findById(id).get();

        LocalDate dateOfBirth = person.getDateOfBirth();

        person.setAge(calculateAge(dateOfBirth, LocalDate.now()));;

        return person;
    }

    private int calculateAge(LocalDate birthDate, LocalDate currentDate) {
        return Period.between(birthDate, currentDate).getYears();
    }
}
