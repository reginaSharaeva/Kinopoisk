package com.itis.dz.services;

import com.itis.dz.entities.Genre;

import javax.transaction.Transactional;
import java.util.List;

public interface GenreService {

    @Transactional
    Genre getGenreById(Long id);

    @Transactional
    List<Genre> getGenres();

    @Transactional
    void addTestData();
}
