package com.itis.dz.repositories;

import com.itis.dz.entities.Person;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public Person getPersonByid(Long id) {
        return (Person) sessionFactory.getCurrentSession().createCriteria(Person.class).add(Restrictions.idEq(id)).uniqueResult();
    }
    public void addPerson(Person person) {
        sessionFactory.getCurrentSession().save(person);
    }
    public List<Person> getPersons() {
        return sessionFactory.getCurrentSession().createCriteria(Person.class).list();
    }
}
