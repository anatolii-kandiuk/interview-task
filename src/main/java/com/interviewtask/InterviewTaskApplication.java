package com.interviewtask;

import com.interviewtask.model.Person;
import com.interviewtask.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class InterviewTaskApplication implements CommandLineRunner {

	@Autowired
	PersonService personService;

	public static void main(String[] args) {

		SpringApplication.run(InterviewTaskApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		System.out.println("Start!!!");

		Person person1 = new Person(1L,"Anatolii", "Kandiuk", LocalDate.of(2001,10,19));
		Person person2 = new Person(2L,"Bogdan", "Pyvoliub", LocalDate.of(1990,1,28));
		Person person3 = new Person(3L, "Stepan", "Sportofil", LocalDate.of(1950,5,29));

		personService.createPerson(person1);
		personService.createPerson(person2);
		personService.createPerson(person3);

	}
}
