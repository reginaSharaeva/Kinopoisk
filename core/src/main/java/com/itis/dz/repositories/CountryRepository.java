package com.itis.dz.repositories;

import com.itis.dz.entities.Country;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CountryRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public Country getCountryById(Long id) {
        return (Country) sessionFactory.getCurrentSession().createCriteria(Country.class).add(Restrictions.idEq(id)).uniqueResult();
    }

    public void addCountry(Country country) {
        sessionFactory.getCurrentSession().save(country);
    }
}
