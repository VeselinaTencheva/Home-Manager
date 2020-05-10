package com.example.demo.service;

import com.example.demo.entity.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;
    public List<Person> getPersons() {
        List<Person> personList = new ArrayList();
        personRepository.findAll().forEach(person -> personList.add(person));

        return personList;
    }

    public Person getPerson(long id) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid person Id:" + id));
        return person;
    }

    public void addPerson(Person person) {
        personRepository.save(person);
    }

    public void updatePerson(long id, Person person) {
        personRepository.save(person);
    }

    public void deletePerson(long id) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid person Id:" + id));
        personRepository.delete(person);
    }

}
