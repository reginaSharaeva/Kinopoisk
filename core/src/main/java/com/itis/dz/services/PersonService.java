package com.itis.dz.services;

import com.itis.dz.entities.Person;

import javax.transaction.Transactional;
import java.util.List;

public interface PersonService {

    @Transactional
    Person getPersonById(Long id);

    @Transactional
    void addTestData();

    @Transactional
    List<Person> getPersons();
}
