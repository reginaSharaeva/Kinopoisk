package com.itis.dz.repositories;

import com.itis.dz.entities.Movie;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public Movie getMovieById(Long id) {
        return (Movie) sessionFactory.getCurrentSession().createCriteria(Movie.class).add(Restrictions.idEq(id)).uniqueResult();
    }

    public List<Movie> getMovies() {
        return sessionFactory.getCurrentSession().createCriteria(Movie.class).list();
    }

    public void addMovie(Movie movie) {
        sessionFactory.getCurrentSession().save(movie);
    }

    public void changeTotalRaiting(Long id, int total) {
        sessionFactory.getCurrentSession().createQuery("update movies m set m.totalraiting = :total where m.id = :id")
                .setInteger("total", total)
                .setLong("id", id).executeUpdate();
    }
}
