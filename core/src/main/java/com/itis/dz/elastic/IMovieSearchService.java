package com.itis.dz.elastic;

import com.itis.dz.entities.Movie;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IMovieSearchService {


    void add(Movie movie);


    void delete(Long id);


    void update(Movie movie);


    List<Movie> matchQuery(String q, Pageable page);

    List<Movie> matchNameQuery(String q);

    List<Movie> matchPhraseQuery(String q);

    List<Movie> matchPhrasePrefixQuery(String q);

    List<Movie> fuzzyQuery(String q);

    String autocomplete(String q);

    List<Movie> matchDescriptionQuery(String description);
    List<Movie> findAll();

    List<Movie> fullFilterQuery(List<String> values, String from, String before);
    List<Movie> yearFilterQuery(String year);
    List<Movie> genresFilterQuery(List<String> values);
    List<Movie> rangeYearFilterQuery(String from, String before);
    List<Movie> genresYearFilterQuery(List<String> values, String year);

}
