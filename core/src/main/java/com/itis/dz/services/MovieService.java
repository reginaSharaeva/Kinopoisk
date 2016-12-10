package com.itis.dz.services;

import com.itis.dz.entities.Movie;

import javax.transaction.Transactional;
import java.util.List;


public interface MovieService {

    @Transactional
    Movie getMovieById(Long id);

    @Transactional
    List<Movie> getMovies();
    @Transactional
    List<Movie> getPopularMovies();
    @Transactional
    List<String> getMoviesGenres();
    @Transactional
    List<Movie> getMoviesWithBigRating();
    @Transactional
    void addTestData();




}
