package com.itis.dz.services;

import com.itis.dz.entities.Person;

import javax.transaction.Transactional;

public interface PersonService {

    @Transactional
    Person getPersonById(Long id);

    @Transactional
    void addTestData();
}
