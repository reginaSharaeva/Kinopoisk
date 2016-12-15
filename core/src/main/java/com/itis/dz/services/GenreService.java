package com.itis.dz.services;

import com.itis.dz.entities.Genre;

import javax.transaction.Transactional;

public interface GenreService {

    @Transactional
    Genre getGenreById(Long id);

    @Transactional
    void addTestData();
}
