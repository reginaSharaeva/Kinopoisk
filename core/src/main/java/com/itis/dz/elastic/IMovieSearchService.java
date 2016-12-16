package com.itis.dz.elastic;

import com.itis.dz.entities.Movie;
import org.springframework.data.domain.Pageable;

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




    List<Movie> searsh(String search, String searchBy, String sort);

    List<Movie> fullSearsh(String search, String searchBy, List<String> values, String from, String to, String sort);

    List<Movie> findAll(String sort);



}
