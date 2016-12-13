package com.itis.dz.repositories;

import com.itis.dz.entities.Award;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AwardRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public Award getAwardById(Long id) {
        return (Award) sessionFactory.getCurrentSession().createCriteria(Award.class).add(Restrictions.idEq(id)).uniqueResult();
    }

    public void addAward(Award award) {
        sessionFactory.getCurrentSession().save(award);
    }
}
