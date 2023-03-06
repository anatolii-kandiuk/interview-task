package com.interviewtask.controller;

import com.interviewtask.dto.PersonDto;
import com.interviewtask.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("person/")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping("{id}")
    public ResponseEntity<PersonDto> getPersonInfo(@PathVariable Long id) {
        return ResponseEntity.ok(personService.getPersonById(id));
    }
}
