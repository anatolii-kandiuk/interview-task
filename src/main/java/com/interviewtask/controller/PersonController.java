package com.interviewtask.controller;

import com.interviewtask.model.Person;
import com.interviewtask.service.PersonService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping("{id}")
    public Person getPersonInfo(@PathVariable Long id) {
        return personService.getPersonById(id);
    }
}
