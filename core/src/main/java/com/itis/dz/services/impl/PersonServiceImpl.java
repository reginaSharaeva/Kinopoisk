package com.itis.dz.services.impl;

import com.itis.dz.entities.Award;
import com.itis.dz.entities.Person;
import com.itis.dz.entities.Role;
import com.itis.dz.repositories.AwardRepository;
import com.itis.dz.repositories.CountryRepository;
import com.itis.dz.repositories.PersonRepository;
import com.itis.dz.repositories.RoleRepository;
import com.itis.dz.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl  implements PersonService {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private AwardRepository awardRepository;

    @Autowired
    private CountryRepository countryRepository;

    public Person getPersonById(Long id) {
        return personRepository.getPersonByid(id);
    }
    public void addTestData(){

       List<Role> roles1=new ArrayList<Role>();
        roles1.add(roleRepository.getRoleById((long)1));
        roles1.add(roleRepository.getRoleById((long)2));

        List<Award> awards1=new ArrayList<Award>();
        awards1.add(awardRepository.getAwardById((long) 1));
        awards1.add(awardRepository.getAwardById((long) 2));

        personRepository.addPerson(new Person("","Скотт","Дерриксон",roles1,awards1,countryRepository.getCountryById((long)1)));
        personRepository.addPerson(new Person("","Джон","Спэйтс",roles1,awards1,countryRepository.getCountryById((long)3)));
        personRepository.addPerson(new Person("","Стивен","Бруссар",roles1,awards1,countryRepository.getCountryById((long)2)));


    }

    public List<Person> getPersons() {
        return personRepository.getPersons();
    }
}
