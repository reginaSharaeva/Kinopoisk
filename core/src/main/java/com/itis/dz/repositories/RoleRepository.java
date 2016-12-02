package com.itis.dz.repositories;

import com.itis.dz.entities.Role;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleRepository {
    @Autowired
    private SessionFactory sessionFactory;
    public Role getRoleById(Long id) {
        return (Role) sessionFactory.getCurrentSession().createCriteria(Role.class).add(Restrictions.idEq(id)).uniqueResult();
    }

    public void addRole(Role role) {
        sessionFactory.getCurrentSession().save(role);
    }
}
