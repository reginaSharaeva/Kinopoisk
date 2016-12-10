package com.itis.dz.repositories;

import com.itis.dz.entities.Genre;
import com.itis.dz.entities.Movie;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
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
    public List<Movie> getMoviesWithBigRating() {

        List<Movie> result;
        Criteria crit2 = sessionFactory.getCurrentSession().createCriteria(Movie.class);
        crit2.addOrder(org.hibernate.criterion.Order.desc("totalraiting"));
        crit2.setMaxResults(5);
        result = crit2.list();
        return result;
    }
    public List<Movie> getPopularMovies() {
        List<Movie> result;
        Criteria crit2 = sessionFactory.getCurrentSession().createCriteria(Movie.class);
        crit2.addOrder(org.hibernate.criterion.Order.desc("totalraiting"));
        crit2.setMaxResults(6);
        result = crit2.list();
        return result;
    }
    public List<String> getMoviesGenres() {
        List<String> result;
        Criteria crit2 = sessionFactory.getCurrentSession().createCriteria(Genre.class);
        crit2.setProjection(Projections.distinct(Projections.property("name")));
        result = crit2.list();
        return result;
    }
    public void changeTotalRaiting(Long id, int total) {
        sessionFactory.getCurrentSession().createQuery("update movies m set m.totalraiting = :total where m.id = :id")
                .setInteger("total", total)
                .setLong("id", id).executeUpdate();
    }
}
