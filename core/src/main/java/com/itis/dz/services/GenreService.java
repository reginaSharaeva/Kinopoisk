package com.itis.dz.services;

import com.itis.dz.entities.Genre;

import javax.transaction.Transactional;
import java.util.List;

public interface GenreService {

    @Transactional
    Genre getGenreById(Long id);

    @Transactional
    void addTestData();

    @Transactional
    List<Genre> getGenres();
}
