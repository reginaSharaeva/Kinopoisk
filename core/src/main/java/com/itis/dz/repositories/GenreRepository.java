package com.itis.dz.repositories;

import com.itis.dz.entities.Genre;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class GenreRepository {
    @Autowired
    private SessionFactory sessionFactory;
    public Genre getGenreById(Long id) {
        return (Genre) sessionFactory.getCurrentSession().createCriteria(Genre.class).add(Restrictions.idEq(id)).uniqueResult();
    }

    public void addGenre(Genre genre) {
        sessionFactory.getCurrentSession().save(genre);
    }

    @Transactional
    public List<Genre> getGenres() {
        return sessionFactory.getCurrentSession().createCriteria(Genre.class).list();
    }

}
