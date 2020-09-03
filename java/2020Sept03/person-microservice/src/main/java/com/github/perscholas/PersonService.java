package com.github.perscholas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leon on 9/3/2020.
 */
@Service
public class PersonService {
    private PersonRepository repository;

    @Autowired
    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public Person create(Person person) {
        return repository.save(person);
    }

    public Person readById(Long id) {
        return repository.findById(id).get();
    }

    public List<Person> readAll() {
        Iterable<Person> personIterable = repository.findAll();
        List<Person> personList = new ArrayList<>();
        personIterable.forEach(personList::add);
        return personList;
    }

    public Person update(Long id, Person newData) {
        Person personInDatabase = readById(id);
        personInDatabase.setFirstName(newData.getFirstName());
        personInDatabase.setLastName(newData.getLastName());
        personInDatabase.setBirthDate(newData.getBirthDate());
        repository.save(personInDatabase);
        return personInDatabase;
    }

    public Person delete(Long id) {
        Person personInDatabase = readById(id);
        repository.delete(personInDatabase);
        return personInDatabase;
    }
}
