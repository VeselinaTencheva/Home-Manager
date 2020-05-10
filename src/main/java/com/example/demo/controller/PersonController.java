package com.example.demo.controller;

import com.example.demo.entity.Person;
import com.example.demo.entity.User;
import com.example.demo.service.PersonService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping
    public List<Person> getPersons(){
        return personService.getPersons();
    }
    @GetMapping("{id}")
    public Person getPersonbyID(@PathVariable("id") long id) {
        return personService.getPerson(id);
    }
    @PostMapping
    public void addPerson(@RequestBody Person person) {
        personService.addPerson(person);
    }
    @PutMapping("{id}")
    public void updatePerson(@PathVariable("id") long id,@RequestBody Person person) {
        personService.updatePerson(id, person);
    }
    @DeleteMapping("{id}")
    public void deletePerson(@PathVariable("id") long id) {
        personService.deletePerson(id);
    }
}
