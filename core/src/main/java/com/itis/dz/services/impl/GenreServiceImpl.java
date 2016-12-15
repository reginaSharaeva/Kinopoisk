package com.itis.dz.services.impl;

import com.itis.dz.entities.Genre;
import com.itis.dz.repositories.GenreRepository;
import com.itis.dz.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class GenreServiceImpl implements GenreService {
    @Autowired
    private GenreRepository genreRepository;

    public Genre getGenreById(Long id) {
        return genreRepository.getGenreById(id);
    }



    public void addTestData(){

        genreRepository.addGenre(new Genre("фантастика"));
        genreRepository.addGenre(new Genre("приключения"));
        genreRepository.addGenre(new Genre("боевик"));


    }

}
