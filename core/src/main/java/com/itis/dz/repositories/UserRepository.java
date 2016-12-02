package com.itis.dz.repositories;

import com.itis.dz.entities.User;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public User getUserByLogin(String login) {
        return (User) sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq("login", login)).uniqueResult();
    }

    public void addUser(String name, String mail, String hash_pass) {
        sessionFactory.getCurrentSession().save(new User(mail, hash_pass, name, "ROLE_USER"));
    }
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }
}

