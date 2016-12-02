package com.itis.dz.services;

import com.itis.dz.entities.Country;

import javax.transaction.Transactional;

public interface CountryService {

    @Transactional
    Country getCountryById(Long id);

    @Transactional
    void addTestData();
}
