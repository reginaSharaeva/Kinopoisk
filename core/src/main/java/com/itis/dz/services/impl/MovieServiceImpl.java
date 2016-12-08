package com.itis.dz.services.impl;

import com.itis.dz.entities.Genre;
import com.itis.dz.entities.Movie;
import com.itis.dz.entities.Person;
import com.itis.dz.entities.Raiting;
import com.itis.dz.repositories.CountryRepository;
import com.itis.dz.repositories.GenreRepository;
import com.itis.dz.repositories.MovieRepository;
import com.itis.dz.repositories.PersonRepository;
import com.itis.dz.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private PersonRepository personRepository;

    public void checkTotalRaiting (Movie movie) {
        List<Raiting> raitings = movie.getRaitings();

        if (raitings.size() - movie.getTotalraiting() > 20) {

            long totalCount = 0;

            for (Raiting r: raitings) {
                totalCount += r.getRaiting();
            }
            int total = (int) (totalCount/raitings.size());

            movieRepository.changeTotalRaiting(movie.getId(), total);
        }
    }

    public Movie getMovieById(Long id) {
        Movie movie = movieRepository.getMovieById(id);
        checkTotalRaiting(movie);

        return movieRepository.getMovieById(id);
    }

    public List<Movie> getMovies() {
        List<Movie> movies = movieRepository.getMovies();

        for (Movie m: movies) {

            checkTotalRaiting(m);
        }
        return movieRepository.getMovies();
    }
    public List<Movie> getMoviesWithBigRating() {
        List<Movie> movies = movieRepository.getMoviesWithBigRating();
        return movieRepository.getMoviesWithBigRating();
    }
    public void addTestData(){


        List<Genre> genres1=new ArrayList<Genre>();
        genres1.add(genreRepository.getGenreById((long)1));
        genres1.add(genreRepository.getGenreById((long)2));
        List<Genre> genres2=new ArrayList<Genre>();
        genres2.add(genreRepository.getGenreById((long)1));
        List<Genre> genres3=new ArrayList<Genre>();
        genres3.add(genreRepository.getGenreById((long)2));

        List<Person> persons1=new ArrayList<Person>();
        persons1.add(personRepository.getPersonByid((long)1));
        persons1.add(personRepository.getPersonByid((long)2));

        Movie movie1 = new Movie("Home run", genres1, persons1, 10, 20, 115, 2016, 16, "/resources/i/page-1_img01.jpg",
                "За гранью сознания лежит новая реальность", countryRepository.getCountryById((long)1));

        Movie movie2 = new Movie("GI Joe retaliation", genres1, persons1, 10, 20, 115, 2016, 16, "/resources/i/page-1_img02_original.jpg",
                "За гранью сознания лежит новая реальность", countryRepository.getCountryById((long)1));

        Movie movie3 = new Movie("Bullet to the head", genres2, persons1, 10, 20, 115, 2016, 16, "/resources/i/1.jpg",
                "За гранью сознания лежит новая реальность", countryRepository.getCountryById((long)1));

        Movie movie4 = new Movie("Broken city", genres3, persons1, 10, 20, 115, 2016, 16, "/resources/i/page-1_img04_original.jpg",
                "За гранью сознания лежит новая реальность", countryRepository.getCountryById((long)1));


        movieRepository.addMovie(movie1);

        movieRepository.addMovie(movie2);

        movieRepository.addMovie(movie3);

        movieRepository.addMovie(movie4);

    }
}
