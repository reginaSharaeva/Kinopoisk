package com.itis.dz.services.impl;

import com.itis.dz.entities.Country;
import com.itis.dz.repositories.CountryRepository;
import com.itis.dz.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryRepository countryRepository;

    public Country getCountryById(Long id) {
        return countryRepository.getCountryById(id);
    }



    public void addTestData(){

        countryRepository.addCountry(new Country("Россия"));
        countryRepository.addCountry(new Country("США"));
        countryRepository.addCountry(new Country("Англия"));

    }


}
